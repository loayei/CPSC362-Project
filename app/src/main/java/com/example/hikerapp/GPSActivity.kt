package com.example.hikerapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_gps.*

private const val PERMISSION_REQUEST = 10

class GPSActivity : AppCompatActivity() {

    lateinit var locationManager: LocationManager
    private var GPSsuccess = false
    private var GPSlocale: Location? = null

    private var permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        disableView()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission(permissions))
            {
                enableView()
            }
            else
            {
                requestPermissions(permissions, PERMISSION_REQUEST)
            }
        } else {
            enableView()
        }
    }

    private fun disableView() {
        coordinate_button.isEnabled = false
        coordinate_button.alpha = 0.5F
    }

    private fun enableView() {
        coordinate_button.isEnabled = true
        coordinate_button.alpha = 1F
        coordinate_button.setOnClickListener { getLocation()}
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        GPSsuccess = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (GPSsuccess) {
            Log.d("CodeAndroidLocation", "GPSsuccess")
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0F, object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    if (location != null) {
                        GPSlocale = location
                        coordinate_text_box.setText("")
                        coordinate_text_box.append("\nGPS ")
                        coordinate_text_box.append("\nLatitude : " + GPSlocale!!.latitude)
                        coordinate_text_box.append("\nLongitude : " + GPSlocale!!.longitude)
                        Log.d("CodeAndroidLocation", " GPS Latitude : " + GPSlocale!!.latitude)
                        Log.d("CodeAndroidLocation", " GPS Longitude : " + GPSlocale!!.longitude)
                    }
                }
            })

            val localGpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (localGpsLocation != null)
                GPSlocale = localGpsLocation
        } else {
            startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }
    }

    private fun checkPermission(permissionArray: Array<String>): Boolean {
        var accessGranted = true
        for (i in permissionArray.indices)
        {
            if (checkCallingOrSelfPermission(permissionArray[i]) == PackageManager.PERMISSION_DENIED)
            {
                accessGranted = false
            }
        }
        return accessGranted
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST) {
            var accessGranted = true
            for (i in permissions.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    accessGranted = false
                    val requestAgain = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(permissions[i])
                    if (requestAgain)
                    {
                        Toast.makeText(this, "Permission failed", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Toast.makeText(this, "Enable permissions in settings.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if (accessGranted)
                enableView()
        }
    }
}