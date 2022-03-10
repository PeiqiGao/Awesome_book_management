<template>
  <div id="app">
   <login v-if="$route.meta.login"></login>
   <stufunctions v-if="$route.meta.stufunctions"></stufunctions>
   <stuborrow v-if="$route.meta.stuborrow"></stuborrow>
   <stuback v-if="$route.meta.stuback"></stuback>
   <mngfunction v-if="$route.meta.mngfunctions"></mngfunction>
   <mngsearch v-if="$route.meta.mngsearch"></mngsearch>
   <mngadd v-if="$route.meta.mngadd"></mngadd>
   <test v-if="$route.meta.test"></test>
   <regist v-if="$route.meta.regist"></regist>
   <mngdelete v-if="$route.meta.mngdelete"></mngdelete>
   <mngchange v-if="$route.meta.mngchange"></mngchange>
   <mngchangebook v-if="$route.meta.mngchangebook"></mngchangebook>
   <mngchoose v-if="$route.meta.mngchoose"></mngchoose>
   <mngpaper v-if="$route.meta.mngpaper"></mngpaper>
   <mngpapersearch v-if="$route.meta.mngpapersearch"></mngpapersearch>
   <mngpaperadd v-if="$route.meta.mngpaperadd"></mngpaperadd>
   <mngpaperdelete v-if="$route.meta.mngpaperdelete"></mngpaperdelete>
   <mngpaperchange v-if="$route.meta.mngpaperchange"></mngpaperchange>
   <mngpaperchange2 v-if="$route.meta.mngpaperchange2"></mngpaperchange2>
   <stupapersearch v-if="$route.meta.stupapersearch"></stupapersearch>
  </div>
</template>

<script>
import stufunctions from './components/stufunctions.vue'
import Login from './components/login.vue'
import Test from './components/test.vue'
import stuborrow from './components/stuborrow.vue'
import Stuback from './components/stuback.vue'
import Mngfunction from './components/mngfunction.vue'
import Mngsearch from './components/mngsearch.vue'
import Mngadd from './components/mngadd.vue'
import Regist from './components/regist.vue'
import Mngdelete from './components/mngdelete.vue'
import Mngchange from './components/mngchange.vue'
import Mngchangebook from './components/mngchangebook.vue'
import Mngchoose from './components/mngchoose.vue'
import Mngpaper from './components/mngpaper.vue'
import Mngpapersearch from './components/mngpapersearch.vue'
import Mngpaperadd from './components/mngpaperadd.vue'
import Mngpaperdelete from './components/mngpaperdelete.vue'
import Mngpaperchange from './components/mngpaperchange.vue'
import mngpaperchange2 from './components/mngpaperchange2.vue'
import Stupapersearch from './components/stupapersearch.vue'






export default {
  components: {Login,stufunctions,Test,stuborrow,Stuback,Mngfunction,Mngsearch,Mngadd,Regist,Mngdelete,Mngchange,Mngchangebook,Mngchoose,Mngpaper,Mngpapersearch,Mngpaperadd,Mngpaperdelete,Mngpaperchange,mngpaperchange2,Stupapersearch},
  name: 'App',
  
  }
</script>

<style>
</style>
