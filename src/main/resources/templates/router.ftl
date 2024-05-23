import {createRouter,createWebHistory} from 'vue-router'
<#list firstRouter as firstrouter>
    import ${firstrouter} from '@/pages/${firstrouter}.vue'
</#list>
<#list firstRouter as firstrouter>
    <#list secondRouter[firstrouter_index] as secondrouter>
    import ${firstrouter}${secondrouter} from '@/pages/${firstrouter}${secondrouter}.vue'
    </#list>
 </#list>
const router = createRouter({
history: createWebHistory(),
routes: [
    <#list firstRouter as firstrouter>
    {
        path:'/${firstrouter}',
        component:${firstrouter},
        children: [
            <#list secondRouter[firstrouter_index] as secondrouter>
            {
                path:'${secondrouter}',
                component:${firstrouter}${secondrouter}
            }<#sep>,
            </#list>
        ]
        }<#sep>,
        </#list>
]
})

export default router;