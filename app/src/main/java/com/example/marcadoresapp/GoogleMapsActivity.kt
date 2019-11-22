package com.example.marcadoresapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions


class GoogleMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        val marcador1 = mMap.addMarker(
            MarkerOptions()
                .position(LatLng(-13.5242178, -71.9754913))
                .title("Machu Picchu - Perú")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador))
        )

        val marcador2 = mMap.addMarker(
            MarkerOptions()
                .position(LatLng(-12.0262676, -77.1278653))
                .title("Lima - Perú")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador))
        )

        val marcador3 = mMap.addMarker(
            MarkerOptions()
                .position(LatLng(40.6892534, -74.0466891))
                .title("Estatua de la Libertad - EEUU")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador))
        )

        val marcador4 = mMap.addMarker(
            MarkerOptions()
                .position(LatLng(48.8583701, 2.2922926))
                .title("Torre Eiffel - Francia")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador))
        )

        // Centrar Marcadores
        val constructor = LatLngBounds.Builder()

        constructor.include(marcador1.getPosition())
        constructor.include(marcador2.getPosition())
        constructor.include(marcador3.getPosition())
        constructor.include(marcador4.getPosition())

        val limites = constructor.build()

        val ancho = resources.displayMetrics.widthPixels
        val alto = resources.displayMetrics.heightPixels
        val padding = (alto * 0.25).toInt() // 25% de espacio (padding) superior e inferior

        val centrarmarcadores = CameraUpdateFactory.newLatLngBounds(limites, ancho, alto, padding)

        mMap.animateCamera(centrarmarcadores)

    }
}
