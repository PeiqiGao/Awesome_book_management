import Vue from 'vue'
import Router from 'vue-router'
import login from '../components/login.vue'
import stufunctions from '../components/stufunctions.vue'
import stuborrow from '../components/stuborrow.vue'
import stuback from '../components/stuback.vue'
import test from '../components/test.vue'
import mngfunctions from '../components/mngfunction.vue'
import mngsearch from '../components/mngsearch.vue'
import mngadd from '../components/mngadd.vue'
import regist from '../components/regist.vue'
import mngdelete from '../components/mngdelete.vue'
import mngchange from '../components/mngchange.vue'
import mngchangebook from '../components/mngchangebook.vue'
import mngchoose from '../components/mngchoose.vue'
import mngpaper from '../components/mngpaper.vue'
import mngpapersearch from '../components/mngpapersearch.vue'
import mngpaperadd from '../components/mngpaperadd.vue'
import mngpaperdelete from '../components/mngpaperdelete.vue'
import mngpaperchange from '../components/mngpaperchange.vue'
import mngpaperchange2 from '../components/mngpaperchange2.vue'
import stupapersearch from '../components/stupapersearch.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'headertop',
      component: {login},
      meta:{login:true}
    },
    {
      path:'/stufunction',
      name:'stufunction',
      component:{stufunctions},
      meta:{stufunctions:true}
    },
    {
      path:'/stuborrow',
      name:'stuborrow',
      component:{stuborrow},
      meta:{stuborrow:true}
    },
    {
      path:'/stuback',
      name:'stuback',
      component:{stuback},
      meta:{stuback:true}
    },
    {
      path:'/mngfunction',
      name:'mngfunction',
      component:{mngfunctions},
      meta:{mngfunctions:true}
    },
    {
      path:'/mngsearch',
      name:'mngsearch',
      component:{mngsearch},
      meta:{mngsearch:true}
    },
    {
      path:'/mngadd',
      name:'mngadd',
      component:{mngadd},
      meta:{mngadd:true}
    },
    {
      path:'/regist',
      name:'regist',
      component:{regist},
      meta:{regist:true}
    },
    {
      path:'/mngdelete',
      name:'mngdelete',
      component:{mngdelete},
      meta:{mngdelete:true}
    },
    {
      path:'/mngchange',
      name:'mngchange',
      component:{mngchange},
      meta:{mngchange:true}
    },
    {
      path:'/mngchangebook',
      name:'mngchangebook',
      component:{mngchangebook},
      meta:{mngchangebook:true}
    },
    {
      path:'/mngchangebook',
      name:'mngchangebook',
      component:{mngchangebook},
      meta:{mngchangebook:true}
    },
    {
      path:'/mngchoose',
      name:'mngchoose',
      component:{mngchoose},
      meta:{mngchoose:true}
    },
    {
      path:'/mngpaper',
      name:'mngpaper',
      component:{mngpaper},
      meta:{mngpaper:true}
    },
    {
      path:'/mngpapersearch',
      name:'mngpapersearch',
      component:{mngpapersearch},
      meta:{mngpapersearch:true}
    },
    {
      path:'/mngpaperadd',
      name:'mngpaperadd',
      component:{mngpaperadd},
      meta:{mngpaperadd:true}
    },
    {
      path:'/mngpaperdelete',
      name:'mngpaperdelete',
      component:{mngpaperdelete},
      meta:{mngpaperdelete:true}
    },
    {
      path:'/mngpaperchange',
      name:'mngpaperchange',
      component:{mngpaperchange},
      meta:{mngpaperchange:true}
    },
    {
      path:'/mngpaperchange2',
      name:'mngpaperchange2',
      component:{mngpaperchange2},
      meta:{mngpaperchange2:true}
    },
    {
      path:'/stupapersearch',
      name:'stupapersearch',
      component:{stupapersearch},
      meta:{stupapersearch:true}
    },
    {
      path:'/test',
      name:'test',
      component:{test},
      meta:{test:true}
    },

  ]
})
