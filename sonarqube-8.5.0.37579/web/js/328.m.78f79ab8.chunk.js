(window.webpackJsonp=window.webpackJsonp||[]).push([[328],{1790:function(e,t,i){"use strict";var a=this&&this.__assign||function(){return(a=Object.assign||function(e){for(var t,i=1,a=arguments.length;i<a;i++)for(var n in t=arguments[i])Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n]);return e}).apply(this,arguments)},n=this&&this.__rest||function(e,t){var i={};for(var a in e)Object.prototype.hasOwnProperty.call(e,a)&&t.indexOf(a)<0&&(i[a]=e[a]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var n=0;for(a=Object.getOwnPropertySymbols(e);n<a.length;n++)t.indexOf(a[n])<0&&Object.prototype.propertyIsEnumerable.call(e,a[n])&&(i[a[n]]=e[a[n]])}return i};Object.defineProperty(t,"__esModule",{value:!0});var o=i(2),r=i(315);t.default=function(e){var t=e.fill,i=void 0===t?"currentColor":t,s=e.hasUnread,l=n(e,["fill","hasUnread"]);return o.createElement(r.ThemedIcon,a({},l),(function(e){var t=e.theme;return s?o.createElement(o.Fragment,null,o.createElement("path",{d:"M8 1a.875.875 0 0 0-.875.875v.57c-2.009.418-3.498 2.118-3.498 4.242 0 2.798-.987 3.652-1.516 4.22a.856.856 0 0 0-.236.593.875.875 0 0 0 .877.875h10.496a.875.875 0 0 0 .877-.875.854.854 0 0 0-.236-.594c-.497-.534-1.388-1.342-1.494-3.76a2.814 2.814 0 0 1-.768.108A2.814 2.814 0 0 1 8.814 4.44a2.814 2.814 0 0 1 .665-1.818 4.543 4.543 0 0 0-.604-.178v-.57A.875.875 0 0 0 8 1zM6.25 13.25a1.75 1.75 0 0 0 3.5 0h-3.5z",style:{fill:i}}),o.createElement("circle",{cx:"11.627",cy:"4.441",r:"2",style:{fill:t.colors.blue}})):o.createElement("path",{d:"M8 15a1.75 1.75 0 0 0 1.75-1.75h-3.5c0 .967.784 1.75 1.75 1.75zm5.89-4.094c-.529-.567-1.517-1.421-1.517-4.218 0-2.125-1.49-3.826-3.499-4.243v-.57a.875.875 0 1 0-1.748 0v.57c-2.01.417-3.499 2.118-3.499 4.243 0 2.797-.988 3.65-1.517 4.218a.854.854 0 0 0-.235.594.876.876 0 0 0 .878.875h10.494a.876.876 0 0 0 .878-.875.853.853 0 0 0-.235-.594z",style:{fill:i}})}))}},1791:function(e,t,i){var a=i(313),n=i(1792);"string"==typeof(n=n.__esModule?n.default:n)&&(n=[[e.i,n,""]]);var o={insert:"head",singleton:!1},r=(a(n,o),n.locals?n.locals:{});e.exports=r},1792:function(e,t,i){(t=i(314)(!1)).push([e.i,".navbar-latest-notification{flex:0 1 240px;text-align:right;overflow:hidden}.navbar-latest-notification-wrapper{position:relative;display:inline-block;padding:8px 8px 8px 50px;height:28px;max-width:100%;box-sizing:border-box;overflow:hidden;vertical-align:middle;font-size:12px;text-overflow:ellipsis;white-space:nowrap;color:#8a8c8f;background-color:#000;border-radius:3px 0 0 3px;cursor:pointer}.navbar-latest-notification-wrapper:hover{color:#cfd3d7}.navbar-latest-notification-wrapper .badge-info{position:absolute;margin-right:8px;left:6px;top:6px}.navbar-latest-notification-wrapper .label{display:block;max-width:330px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap}.navbar-latest-notification-dismiss .navbar-icon{height:28px;background-color:#000;border-radius:0 3px 3px 0;padding:8px 7px!important;margin-left:1px;margin-right:8px;color:#8a8c8f!important}.navbar-latest-notification-dismiss .navbar-icon:hover{color:#cfd3d7!important}.notifications-sidebar{position:fixed;top:0;right:0;bottom:0;width:400px;display:flex;flex-direction:column;background:#f9f9fb}.notifications-sidebar-top{position:relative;display:flex;align-items:center;justify-content:space-between;padding:16px;border-bottom:1px solid #e6e8ea;background-color:#fff}.notifications-sidebar-top h3{font-weight:400;font-size:16px}.notifications-sidebar-content{flex:1 1;overflow-y:auto}.notifications-sidebar-footer{padding-top:8px;border-top:1px solid #e6e8ea;flex:0 0 40px}.notifications-sidebar-slice h4{padding:16px 16px 4px;background-color:#f9f9fb;font-weight:400;font-size:12px;text-align:right;color:#8a8c8f}.notifications-sidebar-slice .feature:last-of-type{border-bottom:1px solid #e6e8ea}.notifications-sidebar-slice .feature{padding:16px;background-color:#fff;border-top:1px solid #e6e8ea;overflow:hidden}.notifications-sidebar-slice.unread .feature{background-color:#e6f6ff;border-color:#cee4f2}.notifications-sidebar-slice .learn-more{clear:both;float:right;margin-top:8px}.notifications-sidebar-slice .categories li{display:inline-block;padding:4px;margin-right:8px;font-size:9px;line-height:8px;text-transform:uppercase;font-weight:700;color:#fff;border-radius:3px}",""]),e.exports=t},1826:function(e,t,i){"use strict";i.r(t),i.d(t,"default",(function(){return f}));var a=i(605),n=i(2),o=i(646),r=i.n(o),s=i(1790),l=i.n(s),c=i(26),p=i(31);i(1791);class f extends n.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.checkHasUnread=()=>{const{notificationsLastReadDate:e,lastNews:t}=this.props;return!e||a(Object(c.parseDate)(t.publicationDate),e)>0},this.handleClick=e=>{e.preventDefault(),e.currentTarget.blur(),this.props.onClick()},this.handleDismiss=e=>{e.preventDefault(),e.stopPropagation(),this.props.setCurrentUserSetting({key:"notifications.readDate",value:Date.now().toString()})}}render(){const{notificationsOptOut:e,lastNews:t}=this.props,i=this.checkHasUnread(),a=Boolean(!e&&t&&i);return n.createElement(n.Fragment,null,a&&n.createElement(n.Fragment,null,n.createElement("li",{className:"navbar-latest-notification",onClick:this.props.onClick},n.createElement("div",{className:"navbar-latest-notification-wrapper"},n.createElement("span",{className:"badge badge-info"},Object(p.translate)("new")),n.createElement("span",{className:"label"},t.notification))),n.createElement("li",{className:"navbar-latest-notification-dismiss"},n.createElement("a",{className:"navbar-icon",href:"#",onClick:this.handleDismiss},n.createElement(r.a,{size:12,thin:!0})))),n.createElement("li",null,n.createElement("a",{className:"navbar-icon",href:"#",onClick:this.handleClick},n.createElement(l.a,{hasUnread:i&&!e}))))}}},554:function(e,t,i){var a=i(32);e.exports=function(e,t){var i=a(e),n=a(t);return i.getTime()-n.getTime()}},605:function(e,t,i){var a=i(554);e.exports=function(e,t){var i=a(e,t)/1e3;return i>0?Math.floor(i):Math.ceil(i)}}}]);
//# sourceMappingURL=328.m.78f79ab8.chunk.js.map