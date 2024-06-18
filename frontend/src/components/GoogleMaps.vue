<template>
  <GoogleMap
    style="width: 100%; height: 400px; border-radius: 5px; overflow: hidden;"
    :center="center"
    :zoom="15"
  >
    <GoogleMapMarker :options="{ position: center }" />
  </GoogleMap>
</template>

<script lang="ts">
  import { GoogleMap, Marker as GoogleMapMarker } from 'vue3-google-map'

  export default {
    name: "GoogleMaps",
    components: {
      GoogleMap,
      GoogleMapMarker,
    },
    data: () => ({
      center: { lat: 48.23946528455359, lng: 16.377302639756127 }
    })
  };
</script>