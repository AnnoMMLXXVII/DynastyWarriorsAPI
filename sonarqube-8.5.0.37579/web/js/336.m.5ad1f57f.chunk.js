(window.webpackJsonp=window.webpackJsonp||[]).push([[336,15,357],{1810:function(e,t,n){"use strict";n.r(t),n.d(t,"default",(function(){return a}));var r=n(2),o=n(462),s=n(551);function a(e){const{extensionKey:t,pluginKey:n}=e.params,{branchLike:a,component:i}=e,c=i.extensions&&i.extensions.find(e=>e.key==="".concat(n,"/").concat(t));return c?r.createElement(s.a,{extension:c,options:{branchLike:a,component:i}}):r.createElement(o.default,{withContainer:!1})}},436:function(e,t,n){"use strict";n.r(t),n.d(t,"default",(function(){return c}));var r=n(2),o=n(495),s=n.n(o),a=n(342),i=n(525);function c({children:e}){return r.createElement("div",{className:"global-container"},r.createElement("div",{className:"page-wrapper",id:"container"},r.createElement(s.a,{className:"navbar-global",height:a.rawSizes.globalNavHeightRaw}),e),r.createElement(i.a,null))}},462:function(e,t,n){"use strict";n.r(t),n.d(t,"default",(function(){return c}));var r=n(2),o=n(332),s=n(316),a=n(31),i=n(436);function c({withContainer:e=!0}){const t=e?i.default:r.Fragment;return r.createElement(t,null,r.createElement(o.a,{defaultTitle:Object(a.translate)("404_not_found"),defer:!1}),r.createElement("div",{className:"page-wrapper-simple",id:"bd"},r.createElement("div",{className:"page-simple",id:"nonav"},r.createElement("h2",{className:"big-spacer-bottom"},Object(a.translate)("page_not_found")),r.createElement("p",{className:"spacer-bottom"},Object(a.translate)("address_mistyped_or_page_moved")),r.createElement("p",null,r.createElement(s.Link,{to:"/"},Object(a.translate)("go_back_to_homepage"))))))}},477:function(e,t,n){"use strict";n.d(t,"b",(function(){return a})),n.d(t,"a",(function(){return i}));var r=n(343),o=n(17);let s=!1;function a(e,t="body"){return new Promise(n=>{const o=document.createElement("script");o.src="".concat(Object(r.getBaseUrl)()).concat(e),o.onload=n,document.getElementsByTagName(t)[0].appendChild(o)})}async function i(e){const t=Object(o.a)(e);if(t)return Promise.resolve(t);if(!s){(0,(await Promise.all([n.e(0),n.e(1),n.e(2),n.e(10),n.e(275)]).then(n.bind(null,636))).default)(),s=!0}await a("/static/".concat(e,".js"));const r=Object(o.a)(e);return r||Promise.reject()}},551:function(e,t,n){"use strict";var r=n(2),o=n(332),s=n(319),a=n(323),i=n(31),c=n(364),l=n(477),p=n(18),u=n(6),m=n(394),d=n(325),h=n(342),b=n(393);function f(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function O(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}class E extends r.PureComponent{constructor(){super(...arguments),this.state={},this.handleStart=e=>{const t=e(function(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?f(Object(n),!0).forEach((function(t){O(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):f(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}({store:Object(b.default)(),el:this.container,currentUser:this.props.currentUser,intl:this.props.intl,location:this.props.location,router:this.props.router,theme:h,baseUrl:Object(u.getBaseUrl)(),l10nBundle:Object(p.a)()},this.props.options));t&&(r.isValidElement(t)?this.setState({extensionElement:t}):"function"==typeof t&&(this.stop=t))},this.handleFailure=()=>{this.props.onFail(Object(i.translate)("page_extension_failed"))}}componentDidMount(){this.startExtension()}componentDidUpdate(e){e.extension!==this.props.extension?(this.stopExtension(),this.startExtension()):e.location!==this.props.location&&this.startExtension()}componentWillUnmount(){this.stopExtension()}startExtension(){Object(l.a)(this.props.extension.key).then(this.handleStart,this.handleFailure)}stopExtension(){this.stop?(this.stop(),this.stop=void 0):this.setState({extensionElement:void 0})}render(){return r.createElement("div",null,r.createElement(o.a,{title:this.props.extension.name}),this.state.extensionElement?this.state.extensionElement:r.createElement("div",{ref:e=>this.container=e}))}}const j={onFail:m.a};t.a=Object(s.injectIntl)(Object(c.a)(Object(a.connect)(e=>({currentUser:Object(d.getCurrentUser)(e)}),j)(E)))}}]);
//# sourceMappingURL=336.m.5ad1f57f.chunk.js.map