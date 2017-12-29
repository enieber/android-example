package com.example.programacaoapp.veicle_revend

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus
import org.osmdroid.views.overlay.OverlayItem
import org.osmdroid.views.overlay.Polyline
import org.osmdroid.views.overlay.infowindow.BasicInfoWindow
import java.util.*

class MapFragment: Fragment() {

    companion object {

        fun newInstance(): MapFragment {
            return MapFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         val rootView = inflater?.inflate(R.layout.fragment_map, container, false)
        val myLocation = Location(-10.0, -50.0)
        val point0 = GeoPoint(-10.10, -50.01)
        val point1 = GeoPoint(-10.11, -50.02)
        val poits: MutableList<GeoPoint> = mutableListOf(point0, point1)
        loadingRouter(rootView, myLocation, poits)
        return rootView
    }

    private fun loadingRouter(rootView:View?, myLocation: Location, ponts: List<GeoPoint>) {
        val ctx = activity
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        val map = rootView?.findViewById(R.id.map) as MapView
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setBuiltInZoomControls(true)
        map.setMultiTouchControls(true)
        val mapController = map.controller
        mapController.setZoom(15)
        val startPoint = GeoPoint(myLocation.latitude, myLocation.longitude)
        mapController.setCenter(startPoint)
        val line = Polyline(ctx)
        line.subDescription = Polyline::class.java.canonicalName
        line.width = 5f
        line.color = ctx.getResources().getColor(R.color.background_material_dark)
        line.points = ponts
        line.isGeodesic = true
        line.infoWindow = BasicInfoWindow(R.layout.bonuspack_bubble, map)

        val myLocation = OverlayItem("Você", "minha localização", GeoPoint(ponts[0].latitude, ponts[0].longitude))
        val newMarker = this.resources.getDrawable(R.drawable.person)
        myLocation.setMarker(newMarker)

        val locationDestination = OverlayItem("Cliente", "Endereço para", GeoPoint(ponts[ponts.size - 1].latitude, ponts[ponts.size - 1].longitude))
        val newMarkerDestinantion = this.resources.getDrawable(R.drawable.marker_default)
        locationDestination.setMarker(newMarkerDestinantion)

        val items = ArrayList<OverlayItem>()
        items.add(myLocation)
        items.add(locationDestination)

        val mOverlay = ItemizedOverlayWithFocus(ctx, items, object : ItemizedIconOverlay.OnItemGestureListener<OverlayItem> {
            override fun onItemSingleTapUp(index: Int, item: OverlayItem): Boolean {
                //do something
                return true
            }

            override fun onItemLongPress(index: Int, item: OverlayItem): Boolean {
                return false
            }
        })
        mOverlay.setFocusItemsOnTap(true)
        map.overlays.add(mOverlay)
        map.overlayManager.add(line)
    }
}