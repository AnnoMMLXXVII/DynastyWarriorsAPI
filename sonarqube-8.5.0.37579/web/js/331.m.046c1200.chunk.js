(window.webpackJsonp=window.webpackJsonp||[]).push([[331],{1868:function(e,t,n){"use strict";n.r(t);var a=n(2),r=n(332),c=n(323),o=n(316),i=n(31),s=n(325),u=(n(572),n(517)),l=(n(678),n(755));var m=n(328),p=n.n(m),d=n(1026),f=n(759);function g({organization:e}){const{actions:t={}}=e;return a.createElement("div",{className:"account-project-card clearfix"},a.createElement("aside",{className:"account-project-side note"},a.createElement("strong",null,Object(i.translate)("organization.key"),":")," ",e.key),a.createElement("h3",{className:"account-project-name"},a.createElement(d.a,{organization:e}),a.createElement(f.a,{className:"spacer-left text-middle",organization:e},e.name),t.admin&&a.createElement("span",{className:"badge spacer-left"},Object(i.translate)("admin"))),!!e.description&&a.createElement("div",{className:"markdown spacer-top"},e.description),!!e.url&&a.createElement("div",{className:"markdown spacer-top"},a.createElement("a",{href:e.url,rel:"nofollow",title:e.url},e.url)))}function h({organizations:e}){return 0===e.length?a.createElement("div",null,Object(i.translate)("my_account.organizations.no_results")):a.createElement("ul",{className:"account-projects-list"},p()(e,e=>e.name.toLocaleLowerCase()).map(e=>a.createElement("li",{key:e.key},a.createElement(g,{organization:e}))))}class b extends a.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!0},this.stopLoading=()=>{this.mounted&&this.setState({loading:!1})}}componentDidMount(){this.mounted=!0,this.props.fetchIfAnyoneCanCreateOrganizations().then(this.stopLoading,this.stopLoading)}componentWillUnmount(){this.mounted=!1}render(){const{anyoneCanCreate:e}=this.props,t=!this.state.loading&&(e||this.props.canAdmin);return a.createElement("div",{className:"account-body account-container"},a.createElement(r.a,{title:Object(i.translate)("my_account.organizations")}),a.createElement("div",{className:"boxed-group"},t&&a.createElement("div",{className:"clearfix"},a.createElement("div",{className:"boxed-group-actions"},a.createElement(o.Link,{className:"button",to:"/create-organization"},Object(i.translate)("create")))),a.createElement("div",{className:"boxed-group-inner"},this.state.loading?a.createElement("i",{className:"spinner"}):a.createElement(h,{organizations:this.props.organizations}))))}}const O={fetchIfAnyoneCanCreateOrganizations:()=>e=>Object(u.e)({keys:"sonar.organizations.anyoneCanCreate"}).then(t=>{e(Object(l.c)(t))})};t.default=Object(c.connect)(e=>{const t=Object(s.getGlobalSettingValue)(e,"sonar.organizations.anyoneCanCreate");return{anyoneCanCreate:Boolean(t&&"true"===t.value),canAdmin:Object(s.getAppState)(e).canAdmin,organizations:Object(s.getMyOrganizations)(e)}},O)(b)},419:function(e,t,n){var a=n(353),r=n(334),c=n(526),o=n(530);e.exports=function(e,t){if(null==e)return{};var n=a(o(e),(function(e){return[e]}));return t=r(t),c(e,n,(function(e,n){return t(e,n[0])}))}},451:function(e,t,n){var a=n(334),r=n(452),c=n(419);e.exports=function(e,t){return c(e,r(a(t)))}},452:function(e,t){e.exports=function(e){if("function"!=typeof e)throw new TypeError("Expected a function");return function(){var t=arguments;switch(t.length){case 0:return!e.call(this);case 1:return!e.call(this,t[0]);case 2:return!e.call(this,t[0],t[1]);case 3:return!e.call(this,t[0],t[1],t[2])}return!e.apply(this,t)}}},517:function(e,t,n){"use strict";n.d(t,"d",(function(){return s})),n.d(t,"e",(function(){return u})),n.d(t,"h",(function(){return l})),n.d(t,"f",(function(){return m})),n.d(t,"g",(function(){return p})),n.d(t,"a",(function(){return d})),n.d(t,"c",(function(){return f})),n.d(t,"b",(function(){return g}));var a=n(451),r=n.n(a),c=n(9),o=n(326),i=n(431);function s(e){return Object(c.getJSON)("/api/settings/list_definitions",{component:e}).then(e=>e.definitions,o.a)}function u(e){return Object(c.getJSON)("/api/settings/values",e).then(e=>e.settings)}function l(e,t,n){const{key:a}=e,o={key:a,component:n};return Object(i.k)(e)&&e.multiValues?o.values=t:"PROPERTY_SET"===e.type?o.fieldValues=t.map(e=>r()(e,e=>null==e)).map(JSON.stringify):o.value=t,Object(c.post)("/api/settings/set",o)}function m(e){return Object(c.post)("/api/settings/reset",e)}function p(e,t,n){return Object(c.post)("/api/emails/send",{to:e,subject:t,message:n})}function d(){return Object(c.getJSON)("/api/settings/check_secret_key").catch(o.a)}function f(){return Object(c.postJSON)("/api/settings/generate_secret_key").catch(o.a)}function g(e){return Object(c.postJSON)("/api/settings/encrypt",{value:e}).catch(o.a)}}}]);
//# sourceMappingURL=331.m.046c1200.chunk.js.map