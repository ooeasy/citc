import {createRouter,createWebHistory} from 'vue-router'
    import first from '@/pages/first.vue'
    import second from '@/pages/second.vue'
    import third from '@/pages/third.vue'
    import firstadd from '@/pages/firstadd.vue'
    import firstdelete from '@/pages/firstdelete.vue'
    import firstselect from '@/pages/firstselect.vue'
    import secondadd from '@/pages/secondadd.vue'
    import seconddelete from '@/pages/seconddelete.vue'
    import secondselect from '@/pages/secondselect.vue'
    import thirda from '@/pages/thirda.vue'
    import thirdb from '@/pages/thirdb.vue'
const router = createRouter({
history: createWebHistory(),
routes: [
    {
        path:'/first',
        component:first,
        children: [
            {
                path:'add',
                component:firstadd
            },
            {
                path:'delete',
                component:firstdelete
            },
            {
                path:'select',
                component:firstselect
            }        ]
        },
    {
        path:'/second',
        component:second,
        children: [
            {
                path:'add',
                component:secondadd
            },
            {
                path:'delete',
                component:seconddelete
            },
            {
                path:'select',
                component:secondselect
            }        ]
        },
    {
        path:'/third',
        component:third,
        children: [
            {
                path:'a',
                component:thirda
            },
            {
                path:'b',
                component:thirdb
            }        ]
        }]
})

export default router;