(window.webpackJsonp=window.webpackJsonp||[]).push([[331],{2220:function(t,e,n){"use strict";n.r(e);var a=n(13),r=n(681),o=n(671),c=n(665),i=n(176),s=n(674),u=(n(922),n(866)),l=(n(1028),n(1101)),p=n(678),f=n.n(p),m=n(1375),d=n(1105);function g(t){var e=t.organization,n=e.actions,r=void 0===n?{}:n;return a.createElement("div",{className:"account-project-card clearfix"},a.createElement("aside",{className:"account-project-side note"},a.createElement("strong",null,Object(i.translate)("organization.key"),":")," ",e.key),a.createElement("h3",{className:"account-project-name"},a.createElement(m.a,{organization:e}),a.createElement(d.a,{className:"spacer-left text-middle",organization:e},e.name),r.admin&&a.createElement("span",{className:"badge spacer-left"},Object(i.translate)("admin"))),!!e.description&&a.createElement("div",{className:"markdown spacer-top"},e.description),!!e.url&&a.createElement("div",{className:"markdown spacer-top"},a.createElement("a",{href:e.url,rel:"nofollow",title:e.url},e.url)))}function h(t){var e=t.organizations;return 0===e.length?a.createElement("div",null,Object(i.translate)("my_account.organizations.no_results")):a.createElement("ul",{className:"account-projects-list"},f()(e,(function(t){return t.name.toLocaleLowerCase()})).map((function(t){return a.createElement("li",{key:t.key},a.createElement(g,{organization:t}))})))}var y,O=(y=function(t,e){return(y=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)},function(t,e){function n(){this.constructor=t}y(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),b=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.state={loading:!0},e.stopLoading=function(){e.mounted&&e.setState({loading:!1})},e}return O(e,t),e.prototype.componentDidMount=function(){this.mounted=!0,this.props.fetchIfAnyoneCanCreateOrganizations().then(this.stopLoading,this.stopLoading)},e.prototype.componentWillUnmount=function(){this.mounted=!1},e.prototype.render=function(){var t=this.props.anyoneCanCreate,e=!this.state.loading&&(t||this.props.canAdmin);return a.createElement("div",{className:"account-body account-container"},a.createElement(r.a,{title:Object(i.translate)("my_account.organizations")}),a.createElement("div",{className:"boxed-group"},e&&a.createElement("div",{className:"clearfix"},a.createElement("div",{className:"boxed-group-actions"},a.createElement(c.Link,{className:"button",to:"/create-organization"},Object(i.translate)("create")))),a.createElement("div",{className:"boxed-group-inner"},this.state.loading?a.createElement("i",{className:"spinner"}):a.createElement(h,{organizations:this.props.organizations}))))},e}(a.PureComponent),v={fetchIfAnyoneCanCreateOrganizations:function(){return function(t){return Object(u.e)({keys:"sonar.organizations.anyoneCanCreate"}).then((function(e){t(Object(l.c)(e))}))}}};e.default=Object(o.connect)((function(t){var e=Object(s.getGlobalSettingValue)(t,"sonar.organizations.anyoneCanCreate");return{anyoneCanCreate:Boolean(e&&"true"===e.value),canAdmin:Object(s.getAppState)(t).canAdmin,organizations:Object(s.getMyOrganizations)(t)}}),v)(b)},768:function(t,e,n){var a=n(702),r=n(683),o=n(875),c=n(879);t.exports=function(t,e){if(null==t)return{};var n=a(c(t),(function(t){return[t]}));return e=r(e),o(t,n,(function(t,n){return e(t,n[0])}))}},799:function(t,e,n){var a=n(683),r=n(800),o=n(768);t.exports=function(t,e){return o(t,r(a(e)))}},800:function(t,e){t.exports=function(t){if("function"!=typeof t)throw new TypeError("Expected a function");return function(){var e=arguments;switch(e.length){case 0:return!t.call(this);case 1:return!t.call(this,e[0]);case 2:return!t.call(this,e[0],e[1]);case 3:return!t.call(this,e[0],e[1],e[2])}return!t.apply(this,e)}}},866:function(t,e,n){"use strict";n.d(e,"d",(function(){return s})),n.d(e,"e",(function(){return u})),n.d(e,"h",(function(){return l})),n.d(e,"f",(function(){return p})),n.d(e,"g",(function(){return f})),n.d(e,"a",(function(){return m})),n.d(e,"c",(function(){return d})),n.d(e,"b",(function(){return g}));var a=n(799),r=n.n(a),o=n(49),c=n(675),i=n(780);function s(t){return Object(o.getJSON)("/api/settings/list_definitions",{component:t}).then((function(t){return t.definitions}),c.a)}function u(t){return Object(o.getJSON)("/api/settings/values",t).then((function(t){return t.settings}))}function l(t,e,n){var a={key:t.key,component:n};return Object(i.k)(t)&&t.multiValues?a.values=e:"PROPERTY_SET"===t.type?a.fieldValues=e.map((function(t){return r()(t,(function(t){return null==t}))})).map(JSON.stringify):a.value=e,Object(o.post)("/api/settings/set",a)}function p(t){return Object(o.post)("/api/settings/reset",t)}function f(t,e,n){return Object(o.post)("/api/emails/send",{to:t,subject:e,message:n})}function m(){return Object(o.getJSON)("/api/settings/check_secret_key").catch(c.a)}function d(){return Object(o.postJSON)("/api/settings/generate_secret_key").catch(c.a)}function g(t){return Object(o.postJSON)("/api/settings/encrypt",{value:t}).catch(c.a)}}}]);
//# sourceMappingURL=331.1601658702741.chunk.js.map