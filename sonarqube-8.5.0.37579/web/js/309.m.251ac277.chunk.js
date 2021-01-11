(window.webpackJsonp=window.webpackJsonp||[]).push([[309],{1867:function(e,t,n){"use strict";n.r(t),n.d(t,"default",(function(){return P}));var r=n(2),a=n(332),i=n(31),o=n(363),s=n(355),l=n(335),c=n(437),u=n(607),p=n(324),f=n.n(p);function g(){return r.createElement("header",{className:"page-header"},r.createElement("div",{className:"page-title display-flex-center"},r.createElement("h1",null,Object(i.translate)("project_quality_profiles.page")),r.createElement(f.a,{className:"spacer-left",overlay:r.createElement("div",{className:"big-padded-top big-padded-bottom"},Object(i.translate)("quality_profiles.list.projects.help"))})),r.createElement("div",{className:"page-description"},Object(i.translate)("project_quality_profiles.page.description")))}var d=n(596),m=n.n(d),h=n(377),y=n.n(h),b=n(345),O=n.n(b);class j extends r.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!1},this.stopLoading=()=>{this.mounted&&this.setState({loading:!1})},this.handleChange=e=>{this.props.profile.key!==e.value&&(this.setState({loading:!0}),this.props.onChangeProfile(this.props.profile.key,e.value).then(this.stopLoading,this.stopLoading))},this.renderProfileName=e=>e.isDefault?r.createElement("span",null,r.createElement("strong",null,Object(i.translate)("default")),": ",e.label):r.createElement("span",null,e.label)}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}renderProfileSelect(){const{profile:e,possibleProfiles:t}=this.props,n=t.map(e=>({value:e.key,label:e.name,isDefault:e.isDefault}));return r.createElement(O.a,{clearable:!1,disabled:this.state.loading,onChange:this.handleChange,optionRenderer:this.renderProfileName,options:n,style:{width:300},value:e.key,valueRenderer:this.renderProfileName})}render(){const{profile:e}=this.props;return r.createElement("tr",{"data-key":e.language},r.createElement("td",{className:"thin nowrap"},e.languageName),r.createElement("td",{className:"thin nowrap"},this.renderProfileSelect()),r.createElement("td",null,this.state.loading&&r.createElement("i",{className:"spinner"})))}}function v(e){const t=y()(e.allProfiles,"language"),n=m()(e.profiles,"languageName").map(n=>r.createElement(j,{key:n.language,onChangeProfile:e.onChangeProfile,possibleProfiles:t[n.language],profile:n}));return r.createElement("div",{className:"boxed-group boxed-group-inner"},r.createElement("table",{className:"data zebra"},r.createElement("thead",null,r.createElement("tr",null,r.createElement("th",{className:"thin nowrap"},Object(i.translate)("language")),r.createElement("th",{className:"thin nowrap"},Object(i.translate)("quality_profile")),r.createElement("th",null," "))),r.createElement("tbody",null,n)))}class P extends r.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!0},this.handleChangeProfile=(e,t)=>{const{component:n}=this.props,{allProfiles:r,profiles:a}=this.state,s=r&&r.find(t=>t.key===e),l=r&&r.find(e=>e.key===t);let u;return l&&(u=l.isDefault&&s?Object(o.m)(s,n.key):Object(o.d)(l,n.key)),u?u.then(()=>{if(this.mounted&&a&&l){const t=[...a.filter(t=>t.key!==e),l];this.setState({profiles:t}),Object(c.a)(Object(i.translateWithParameters)("project_quality_profile.successfully_updated",l.languageName))}}):Promise.resolve()}}componentDidMount(){this.mounted=!0,this.checkPermissions()?this.fetchProfiles():Object(u.a)()}componentWillUnmount(){this.mounted=!1}checkPermissions(){const{configuration:e}=this.props.component;return!!(e&&e.showQualityProfiles)}fetchProfiles(){const{key:e,organization:t}=this.props.component;Promise.all([Object(o.A)({organization:t}).then(e=>e.profiles),Object(o.A)({organization:t,project:e}).then(e=>e.profiles)]).then(([e,t])=>{this.mounted&&this.setState({loading:!1,allProfiles:e,profiles:t})},()=>{this.mounted&&this.setState({loading:!1})})}render(){if(!this.checkPermissions())return null;const{allProfiles:e,loading:t,profiles:n}=this.state;return r.createElement("div",{className:"page page-limited"},r.createElement(l.a,{suggestions:"project_quality_profiles"}),r.createElement(a.a,{defer:!1,title:Object(i.translate)("project_quality_profiles.page")}),r.createElement(s.a,{anchor:"profiles_main"}),r.createElement(g,null),t?r.createElement("i",{className:"spinner"}):e&&n&&r.createElement(v,{allProfiles:e,onChangeProfile:this.handleChangeProfile,profiles:n}))}}},324:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n(311),a=n(2),i=n(372),o=n(338);n(339);var s=n(318);t.default=function(e){var t=e.tagName,n=void 0===t?"div":t;return a.createElement(n,{className:r("help-tooltip",e.className)},a.createElement(s.default,{mouseLeaveDelay:.25,onShow:e.onShow,overlay:e.overlay,placement:e.placement},a.createElement("span",{className:"display-inline-flex-center"},e.children||a.createElement(o.ThemeConsumer,null,(function(e){return a.createElement(i.default,{fill:e.colors.gray71,size:12})})))))}},335:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var r=n(2),a=n(368);function i({suggestions:e}){return r.createElement(a.a.Consumer,null,({addSuggestions:t,removeSuggestions:n})=>r.createElement(o,{addSuggestions:t,removeSuggestions:n,suggestions:e}))}class o extends r.PureComponent{componentDidMount(){this.props.addSuggestions(this.props.suggestions)}componentDidUpdate(e){e.suggestions!==this.props.suggestions&&(this.props.removeSuggestions(this.props.suggestions),this.props.addSuggestions(e.suggestions))}componentWillUnmount(){this.props.removeSuggestions(this.props.suggestions)}render(){return null}}},339:function(e,t,n){var r=n(313),a=n(340);"string"==typeof(a=a.__esModule?a.default:a)&&(a=[[e.i,a,""]]);var i={insert:"head",singleton:!1},o=(r(a,i),a.locals?a.locals:{});e.exports=o},340:function(e,t,n){(t=n(314)(!1)).push([e.i,".help-tooltip{display:inline-flex;align-items:center;vertical-align:middle}.help-toolip-link{display:block;width:12px;height:12px;border:none}",""]),e.exports=t},354:function(e,t,n){var r=n(353),a=n(334),i=n(429),o=n(367);e.exports=function(e,t){return(o(e)?r:i)(e,a(t,3))}},355:function(e,t,n){"use strict";n.d(t,"a",(function(){return o}));var r=n(2),a=n(31),i=n(404);function o(e){return r.createElement(i.a.Consumer,null,({addA11ySkipLink:t,removeA11ySkipLink:n})=>r.createElement(s,Object.assign({addA11ySkipLink:t,removeA11ySkipLink:n},e)))}class s extends r.PureComponent{constructor(){super(...arguments),this.getLink=()=>{const{anchor:e,label:t=Object(a.translate)("skip_to_content"),weight:n}=this.props;return{key:e,label:t,weight:n}}}componentDidMount(){this.props.addA11ySkipLink(this.getLink())}componentWillUnmount(){this.props.removeA11ySkipLink(this.getLink())}render(){const{anchor:e}=this.props;return r.createElement("span",{id:"a11y_target__".concat(e)})}}},363:function(e,t,n){"use strict";n.d(t,"A",(function(){return u})),n.d(t,"s",(function(){return p})),n.d(t,"j",(function(){return f})),n.d(t,"y",(function(){return g})),n.d(t,"r",(function(){return d})),n.d(t,"q",(function(){return m})),n.d(t,"C",(function(){return h})),n.d(t,"x",(function(){return y})),n.d(t,"i",(function(){return b})),n.d(t,"l",(function(){return O})),n.d(t,"g",(function(){return j})),n.d(t,"t",(function(){return v})),n.d(t,"u",(function(){return P})),n.d(t,"o",(function(){return q})),n.d(t,"n",(function(){return E})),n.d(t,"p",(function(){return k})),n.d(t,"h",(function(){return S})),n.d(t,"d",(function(){return N})),n.d(t,"m",(function(){return _})),n.d(t,"B",(function(){return w})),n.d(t,"z",(function(){return z})),n.d(t,"c",(function(){return x})),n.d(t,"w",(function(){return C})),n.d(t,"b",(function(){return J})),n.d(t,"v",(function(){return D})),n.d(t,"e",(function(){return L})),n.d(t,"f",(function(){return A})),n.d(t,"a",(function(){return M})),n.d(t,"k",(function(){return U}));var r=n(354),a=n.n(r),i=n(463),o=n(9),s=n(326);function l(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function c(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function u(e){return Object(o.getJSON)("/api/qualityprofiles/search",e).catch(s.a)}function p({compareToSonarWay:e,profile:{key:t}}){return Object(o.getJSON)("/api/qualityprofiles/show",{compareToSonarWay:e,key:t})}function f(e){return Object(o.postJSON)("/api/qualityprofiles/create",e).catch(s.a)}function g(e){return Object(o.postJSON)("/api/qualityprofiles/restore",e).catch(s.a)}function d(e){return Object(o.getJSON)("/api/qualityprofiles/projects",e).catch(s.a)}function m({language:e,name:t,organization:n}){return Object(o.getJSON)("/api/qualityprofiles/inheritance",{language:e,qualityProfile:t,organization:n}).catch(s.a)}function h({language:e,name:t,organization:n}){return Object(o.post)("/api/qualityprofiles/set_default",{language:e,qualityProfile:t,organization:n})}function y(e,t){return Object(o.post)("/api/qualityprofiles/rename",{key:e,name:t}).catch(s.a)}function b(e,t){return Object(o.postJSON)("/api/qualityprofiles/copy",{fromKey:e,toName:t}).catch(s.a)}function O({language:e,name:t,organization:n}){return Object(o.post)("/api/qualityprofiles/delete",{language:e,qualityProfile:t,organization:n}).catch(s.a)}function j({language:e,name:t,organization:n},r){return Object(o.post)("/api/qualityprofiles/change_parent",{language:e,qualityProfile:t,organization:n,parentQualityProfile:r?r.name:void 0}).catch(s.a)}function v({language:e,name:t,organization:n}){const r=Object.entries({language:e,qualityProfile:t,organization:n}).map(([e,t])=>"".concat(e,"=").concat(encodeURIComponent(t))).join("&");return"/api/qualityprofiles/backup?".concat(r)}function P({key:e},{language:t,name:n,organization:r}){const a=Object.entries({exporterKey:e,language:t,qualityProfile:n,organization:r}).map(([e,t])=>"".concat(e,"=").concat(encodeURIComponent(t))).join("&");return"/api/qualityprofiles/export?".concat(a)}function q(){return Object(o.getJSON)("/api/qualityprofiles/importers").then(e=>e.importers,s.a)}function E(){return Object(o.getJSON)("/api/qualityprofiles/exporters").then(e=>e.exporters)}function k(e,t,{language:n,name:r,organization:a},i){return Object(o.getJSON)("/api/qualityprofiles/changelog",{since:e,to:t,language:n,qualityProfile:r,organization:a,p:i})}function S(e,t){return Object(o.getJSON)("/api/qualityprofiles/compare",{leftKey:e,rightKey:t})}function N({language:e,name:t,organization:n},r){return Object(o.post)("/api/qualityprofiles/add_project",{language:e,qualityProfile:t,organization:n,project:r}).catch(s.a)}function _({language:e,name:t,organization:n},r){return Object(o.post)("/api/qualityprofiles/remove_project",{language:e,qualityProfile:t,organization:n,project:r}).catch(s.a)}function w(e){return Object(o.getJSON)("/api/qualityprofiles/search_users",e).catch(s.a)}function z(e){return Object(o.getJSON)("/api/qualityprofiles/search_groups",e).catch(s.a)}function x(e){return Object(o.post)("/api/qualityprofiles/add_user",e).catch(s.a)}function C(e){return Object(o.post)("/api/qualityprofiles/remove_user",e).catch(s.a)}function J(e){return Object(o.post)("/api/qualityprofiles/add_group",e).catch(s.a)}function D(e){return Object(o.post)("/api/qualityprofiles/remove_group",e).catch(s.a)}function L(e){return Object(o.postJSON)("/api/qualityprofiles/activate_rules",e)}function A(e){return Object(o.postJSON)("/api/qualityprofiles/deactivate_rules",e)}function M(e){const t=e.params&&a()(e.params,(e,t)=>"".concat(t,"=").concat(Object(i.csvEscape)(e))).join(";");return Object(o.post)("/api/qualityprofiles/activate_rule",function(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?l(Object(n),!0).forEach((function(t){c(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):l(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}({},e,{params:t})).catch(s.a)}function U(e){return Object(o.post)("/api/qualityprofiles/deactivate_rule",e).catch(s.a)}},377:function(e,t,n){var r=n(442),a=n(395),i=Object.prototype.hasOwnProperty,o=a((function(e,t,n){i.call(e,n)?e[n].push(t):r(e,n,[t])}));e.exports=o},437:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var r=n(394),a=n(393);function i(e){Object(a.default)().dispatch(r.b(e))}},463:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.csvEscape=function(e){return'"'+e.replace(/"/g,'\\"')+'"'}},607:function(e,t,n){"use strict";n.d(t,"a",(function(){return s}));var r=n(37),a=n.n(r),i=n(544),o=n(393);function s(){const e=Object(o.default)(),t=a()(),n=window.location.pathname+window.location.search+window.location.hash;e.dispatch(Object(i.c)()),t.replace({pathname:"/sessions/new",query:{return_to:n}})}}}]);
//# sourceMappingURL=309.m.251ac277.chunk.js.map