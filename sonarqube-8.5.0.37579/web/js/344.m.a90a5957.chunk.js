(window.webpackJsonp=window.webpackJsonp||[]).push([[344],{1825:function(e,t,n){"use strict";n.r(t),n.d(t,"default",(function(){return p})),n.d(t,"isUnread",(function(){return b})),n.d(t,"Notification",(function(){return E})),n.d(t,"Feature",(function(){return g}));var a=n(311),r=n(605),o=n(2),i=n(312),c=n(330),l=n.n(c),s=n(351),u=n.n(s),m=n(317),f=n.n(m),d=n(31);function p(e){const{loading:t,loadingMore:n,news:a,notificationsLastReadDate:r,paging:c}=e,s=Object(d.translate)("embed_docs.whats_new");return o.createElement(l.a,{contentLabel:s,onRequestClose:e.onClose},o.createElement("div",{className:"notifications-sidebar"},o.createElement("div",{className:"notifications-sidebar-top"},o.createElement("h3",null,s),o.createElement(i.ClearButton,{className:"button-tiny",iconProps:{size:12,thin:!0},onClick:e.onClose})),o.createElement("div",{className:"notifications-sidebar-content"},t?o.createElement("div",{className:"text-center"},o.createElement(f.a,{className:"big-spacer-top",timeout:200})):a.map((e,t)=>o.createElement(E,{key:e.publicationDate,notification:e,unread:b(t,e.publicationDate,r)}))),!t&&c&&c.total>a.length&&o.createElement("div",{className:"notifications-sidebar-footer"},o.createElement("div",{className:"spacer-top note text-center"},o.createElement("a",{className:"spacer-left",href:"#",onClick:e.fetchMoreFeatureNews},Object(d.translate)("show_more")),n&&o.createElement(f.a,{className:"text-bottom spacer-left position-absolute"})))))}function b(e,t,n){return n?r(t,n)>0:e<1}function E({notification:e,unread:t}){return o.createElement("div",{className:a("notifications-sidebar-slice",{unread:t})},o.createElement("h4",null,o.createElement(u.a,{date:e.publicationDate,long:!1})),e.features.map((e,t)=>o.createElement(g,{feature:e,key:t})))}function g({feature:e}){return o.createElement("div",{className:"feature"},o.createElement("ul",{className:"categories spacer-bottom"},e.categories.map(e=>o.createElement("li",{key:e.name,style:{backgroundColor:e.color}},e.name))),o.createElement("span",null,e.description),e.readMore&&o.createElement("a",{className:"learn-more",href:e.readMore,rel:"noopener noreferrer nofollow",target:"_blank"},Object(d.translate)("learn_more")))}},351:function(e,t,n){"use strict";var a=this&&this.__assign||function(){return(a=Object.assign||function(e){for(var t,n=1,a=arguments.length;n<a;n++)for(var r in t=arguments[n])Object.prototype.hasOwnProperty.call(t,r)&&(e[r]=t[r]);return e}).apply(this,arguments)};Object.defineProperty(t,"__esModule",{value:!0});var r=n(2),o=n(319),i=n(26);t.formatterOption={year:"numeric",month:"short",day:"2-digit"},t.longFormatterOption={year:"numeric",month:"long",day:"numeric"},t.default=function(e){var n=e.children,c=e.date,l=e.long;return r.createElement(o.FormattedDate,a({value:i.parseDate(c)},l?t.longFormatterOption:t.formatterOption),n)}},554:function(e,t,n){var a=n(32);e.exports=function(e,t){var n=a(e),r=a(t);return n.getTime()-r.getTime()}},605:function(e,t,n){var a=n(554);e.exports=function(e,t){var n=a(e,t)/1e3;return n>0?Math.floor(n):Math.ceil(n)}}}]);
//# sourceMappingURL=344.m.a90a5957.chunk.js.map