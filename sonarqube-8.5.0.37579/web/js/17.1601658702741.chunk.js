(window.webpackJsonp=window.webpackJsonp||[]).push([[17],{1091:function(e,t,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var a in t=arguments[n])Object.prototype.hasOwnProperty.call(t,a)&&(e[a]=t[a]);return e}).apply(this,arguments)},a=this&&this.__rest||function(e,t){var n={};for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&t.indexOf(r)<0&&(n[r]=e[r]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var a=0;for(r=Object.getOwnPropertySymbols(e);a<r.length;a++)t.indexOf(r[a])<0&&Object.prototype.propertyIsEnumerable.call(e,r[a])&&(n[r[a]]=e[r[a]])}return n};Object.defineProperty(t,"__esModule",{value:!0});var s=n(13),o=n(664);t.default=function(e){var t=e.fill,n=a(e,["fill"]);return s.createElement(o.ThemedIcon,r({},n),(function(e){var n=e.theme;return s.createElement("path",{d:"M9 12.242v-1.484c0-.14-.11-.258-.25-.258h-1.5c-.14 0-.25.117-.25.258v1.484c0 .14.11.258.25.258h1.5c.14 0 .25-.117.25-.258zM8.984 9.32l.141-3.586a.189.189 0 0 0-.078-.148C9 5.546 8.93 5.5 8.859 5.5H7.141c-.07 0-.141.047-.188.086-.055.039-.078.117-.078.164l.133 3.57c0 .102.117.18.265.18H8.72c.14 0 .258-.078.265-.18zm-.109-7.297l6 11A1 1 0 0 1 14 14.5H2a1 1 0 0 1-.875-1.477l6-11a.994.994 0 0 1 1.75 0z",style:{fill:t||n.colors.warningIconColor}})}))}},2178:function(e,t,n){"use strict";n.r(t),n.d(t,"AnalysisWarningsModal",(function(){return v}));var r,a=n(820),s=n(13),o=n(661),i=n(679),l=n.n(i),c=n(1091),u=n.n(c),p=n(666),d=n.n(p),f=n(176),h=n(923),m=n(823),y=(r=function(e,t){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}r(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),g=function(e,t,n,r){return new(n||(n=Promise))((function(a,s){function o(e){try{l(r.next(e))}catch(e){s(e)}}function i(e){try{l(r.throw(e))}catch(e){s(e)}}function l(e){var t;e.done?a(e.value):(t=e.value,t instanceof n?t:new n((function(e){e(t)}))).then(o,i)}l((r=r.apply(e,t||[])).next())}))},b=function(e,t){var n,r,a,s,o={label:0,sent:function(){if(1&a[0])throw a[1];return a[1]},trys:[],ops:[]};return s={next:i(0),throw:i(1),return:i(2)},"function"==typeof Symbol&&(s[Symbol.iterator]=function(){return this}),s;function i(s){return function(i){return function(s){if(n)throw new TypeError("Generator is already executing.");for(;o;)try{if(n=1,r&&(a=2&s[0]?r.return:s[0]?r.throw||((a=r.return)&&a.call(r),0):r.next)&&!(a=a.call(r,s[1])).done)return a;switch(r=0,a&&(s=[2&s[0],a.value]),s[0]){case 0:case 1:a=s;break;case 4:return o.label++,{value:s[1],done:!1};case 5:o.label++,r=s[1],s=[0];continue;case 7:s=o.ops.pop(),o.trys.pop();continue;default:if(!(a=(a=o.trys).length>0&&a[a.length-1])&&(6===s[0]||2===s[0])){o=0;continue}if(3===s[0]&&(!a||s[1]>a[0]&&s[1]<a[3])){o.label=s[1];break}if(6===s[0]&&o.label<a[1]){o.label=a[1],a=s;break}if(a&&o.label<a[2]){o.label=a[2],o.ops.push(s);break}a[2]&&o.ops.pop(),o.trys.pop();continue}s=t.call(e,o)}catch(e){s=[6,e],r=0}finally{n=a=0}if(5&s[0])throw s[1];return{value:s[0]?s[1]:void 0,done:!0}}([s,i])}}},v=function(e){function t(t){var n=e.call(this,t)||this;return n.mounted=!1,n.handleDismissMessage=function(e){return g(n,void 0,void 0,(function(){var t;return b(this,(function(n){switch(n.label){case 0:if(void 0===(t=this.props.componentKey))return[2];this.setState({dismissedWarning:e}),n.label=1;case 1:return n.trys.push([1,3,,4]),[4,Object(h.c)(t,e)];case 2:return n.sent(),this.props.onWarningDismiss&&this.props.onWarningDismiss(),[3,4];case 3:return n.sent(),[3,4];case 4:return this.mounted&&this.setState({dismissedWarning:void 0}),[2]}}))}))},n.loadWarnings=function(e){return g(n,void 0,void 0,(function(){var t,n;return b(this,(function(r){switch(r.label){case 0:this.setState({loading:!0}),r.label=1;case 1:return r.trys.push([1,3,,4]),[4,Object(h.h)(e,["warnings"])];case 2:return t=r.sent().warnings,n=void 0===t?[]:t,this.mounted&&this.setState({loading:!1,warnings:n.map((function(e){return{key:e,message:e,dismissable:!1}}))}),[3,4];case 3:return r.sent(),this.mounted&&this.setState({loading:!1}),[3,4];case 4:return[2]}}))}))},n.state={loading:!t.warnings,warnings:t.warnings||[]},n}return y(t,e),t.prototype.componentDidMount=function(){this.mounted=!0,!this.props.warnings&&this.props.taskId&&this.loadWarnings(this.props.taskId)},t.prototype.componentDidUpdate=function(e){var t=this.props,n=t.taskId,r=t.warnings;!r&&n&&e.taskId!==n?this.loadWarnings(n):r&&e.warnings!==r&&this.setState({warnings:r})},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this,t=this.props.currentUser,n=this.state,r=n.loading,i=n.dismissedWarning,c=n.warnings,p=Object(f.translate)("warnings");return s.createElement(l.a,{contentLabel:p,onRequestClose:this.props.onClose},s.createElement("header",{className:"modal-head"},s.createElement("h2",null,p)),s.createElement("div",{className:"modal-body modal-container js-analysis-warnings"},s.createElement(d.a,{loading:r},c.map((function(n){var r=n.dismissable,l=n.key,c=n.message;return s.createElement("div",{className:"panel panel-vertical",key:l},s.createElement(u.a,{className:"pull-left spacer-right"}),s.createElement("div",{className:"overflow-hidden markdown"},s.createElement("span",{dangerouslySetInnerHTML:{__html:Object(a.sanitize)(c.trim().replace(/\n/g,"<br />"),{ALLOWED_ATTR:["target","href"]})}}),r&&t.isLoggedIn&&s.createElement("div",{className:"spacer-top display-flex-inline"},s.createElement(o.ButtonLink,{className:"link-base-color",disabled:Boolean(i),onClick:function(){e.handleDismissMessage(l)}},Object(f.translate)("dismiss_permanently")),i===l&&s.createElement("i",{className:"spinner spacer-left"}))))})))),s.createElement("footer",{className:"modal-foot"},s.createElement(o.ButtonLink,{className:"js-modal-close",onClick:this.props.onClose},Object(f.translate)("close"))))},t}(s.PureComponent);t.default=Object(m.a)(v)}}]);
//# sourceMappingURL=17.1601658702741.chunk.js.map