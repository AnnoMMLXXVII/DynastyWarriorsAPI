(window.webpackJsonp=window.webpackJsonp||[]).push([[8],{1149:function(e,t,n){"use strict";n.d(t,"a",(function(){return b}));var r=n(328),o=n.n(r),s=n(377),i=n.n(s),c=n(2),l=n(316),a=n(344),u=n.n(a),p=n(322),d=n(31),m=n(391),h=n(327),f=n(321);class b extends c.PureComponent{constructor(){super(...arguments),this.isDifferentComponent=(e,t)=>Boolean(e&&t&&(e.project!==t.project||e.subProject!==t.subProject)),this.handleFileClick=e=>{e.preventDefault(),e.currentTarget.blur();const{key:t,line:n}=e.currentTarget.dataset;this.shouldLink()&&t&&this.props.openComponent({branchLike:this.props.branchLike,key:t,line:n?Number(n):void 0})}}shouldLink(){const{branchLike:e}=this.props;return!Object(h.h)(e)}renderDuplication(e,t,n){return this.shouldLink()?c.createElement("a",{"data-key":e.key,"data-line":n,href:"#",onClick:this.handleFileClick,title:e.name},t):t}render(){const{duplicatedFiles:e={},sourceViewerFile:t}=this.props,n=i()(this.props.blocks,"_ref");let r=Object.keys(n).map(t=>({blocks:n[t],file:e[t]}));return r=o()(r,e=>e.file.projectName!==t.projectName,e=>e.file.subProjectName!==t.subProjectName,e=>e.file.key!==t.key),c.createElement("div",{className:"source-viewer-bubble-popup abs-width-400"},this.props.inRemovedComponent&&c.createElement(p.Alert,{variant:"warning"},Object(d.translate)("duplications.dups_found_on_deleted_resource")),r.length>0&&c.createElement(c.Fragment,null,c.createElement("h6",{className:"spacer-bottom"},Object(d.translate)("component_viewer.transition.duplication")),r.map(e=>c.createElement("div",{className:"spacer-top text-ellipsis",key:e.file.key},c.createElement("div",{className:"component-name"},this.isDifferentComponent(e.file,this.props.sourceViewerFile)&&c.createElement(c.Fragment,null,c.createElement("div",{className:"component-name-parent"},c.createElement(u.a,{className:"little-spacer-right",qualifier:"TRK"}),c.createElement(l.Link,{to:Object(f.u)(e.file.project)},e.file.projectName)),e.file.subProject&&e.file.subProjectName&&c.createElement("div",{className:"component-name-parent"},c.createElement(u.a,{className:"little-spacer-right",qualifier:"BRC"}),e.file.subProjectName)),e.file.key!==this.props.sourceViewerFile.key&&c.createElement("div",{className:"component-name-path"},this.renderDuplication(e.file,c.createElement(c.Fragment,null,c.createElement("span",null,Object(m.collapsedDirFromPath)(e.file.name)),c.createElement("span",{className:"component-name-file"},Object(m.fileFromPath)(e.file.name))))),c.createElement("div",{className:"component-name-path"},"Lines: ",e.blocks.map((t,n)=>c.createElement(c.Fragment,{key:n},this.renderDuplication(e.file,c.createElement(c.Fragment,null,t.from," – ",t.from+t.size-1),t.from),n<e.blocks.length-1&&", "))))))))}}},1150:function(e,t,n){"use strict";function r(e,t){let n=!1;return e.filter(e=>{const r=e.from>t||e.from+e.size<t,o=!("1"===e._ref)||(r||n),s=void 0!==e._ref&&o;return"1"!==e._ref||r||(n=!0),s})}function o(e,t){return e&&e[t]&&e[t].blocks||[]}function s(e){return e.some(e=>void 0===e._ref)}n.d(t,"a",(function(){return r})),n.d(t,"b",(function(){return o})),n.d(t,"c",(function(){return s}))},377:function(e,t,n){var r=n(442),o=n(395),s=Object.prototype.hasOwnProperty,i=o((function(e,t,n){s.call(e,n)?e[n].push(t):r(e,n,[t])}));e.exports=i},602:function(e,t,n){"use strict";n.d(t,"c",(function(){return c})),n.d(t,"b",(function(){return l})),n.d(t,"d",(function(){return a})),n.d(t,"a",(function(){return u})),n.d(t,"e",(function(){return p}));var r=n(671),o=n.n(r),s=n(697),i=n(650);function c(e){const t={};return e.forEach(e=>{const n=e.textRange?e.textRange.endLine:0;n in t||(t[n]=[]),t[n].push(e)}),t}function l(e=[]){return e.reduce((e,t)=>{e[t.component]=e[t.component]||{};const n=t.textRange?t.textRange.endLine:0;return e[t.component][n]=e[t.component][n]||[],e[t.component][n].push(t),e},{})}function a(e){const t={};return e.forEach(e=>{Object(i.a)(e.textRange).forEach(e=>{e.line in t||(t[e.line]=[]),t[e.line].push(e)})}),t}function u(e){if(null==e)return{};const t={};return e.forEach(({blocks:e},n)=>{e.forEach(e=>{if("1"===e._ref)for(let r=e.from;r<e.from+e.size;r++)r in t||(t[r]=[]),t[r].push(n)})}),t}function p(e){const t={};return e.forEach(e=>{const n=Object(s.c)(e.code||""),r=o()(n.map(e=>{const t=e.className.match(/sym-\d+/g);return null!=t?t:[]}));t[e.line]=r.filter(e=>e)}),t}},650:function(e,t,n){"use strict";function r(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function o(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function s(e){if(!e)return[];const t=[];for(let n=e.startLine;n<=e.endLine;n++){const r=n===e.startLine?e.startOffset:0,o=n===e.endLine?e.endOffset:999999;t.push({line:n,from:r,to:o})}return t}function i(e,t){return t?t.reduce((t,n)=>[...t,...n?s(n.textRange).filter(t=>t.line===e.line).map(e=>function(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?r(Object(n),!0).forEach((function(t){o(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):r(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}({},e,{startLine:n.textRange.startLine,index:n.index,text:n.msg})):[]],[]):[]}n.d(t,"a",(function(){return s})),n.d(t,"b",(function(){return i}))},651:function(e,t,n){"use strict";n.d(t,"a",(function(){return o}));var r=n(2);const o=r.createContext({branchLike:{},file:{}})},653:function(e,t,n){var r=n(353),o=n(709),s=n(430),i=n(710),c=s((function(e){var t=r(e,i);return t.length&&t[0]===e[0]?o(t):[]}));e.exports=c},697:function(e,t,n){"use strict";n.d(t,"c",(function(){return l})),n.d(t,"b",(function(){return a})),n.d(t,"a",(function(){return p}));var r=n(412),o=n.n(r);function s(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?s(Object(n),!0).forEach((function(t){c(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):s(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function c(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function l(e,t=""){const n=document.createElement("div");let r=[];return n.innerHTML=e,[].forEach.call(n.childNodes,e=>{if(1===e.nodeType){const n=t?t+" "+e.className:e.className,o=l(e.innerHTML,n);r=r.concat(o)}3===e.nodeType&&e.nodeValue&&r.push({className:t,markers:[],text:e.nodeValue})}),r}function a(e,t){const n=new RegExp("\\b".concat(t,"\\b"));return e.map(e=>n.test(e.className)?i({},e,{className:"".concat(e.className," highlighted")}):e)}function u(e,t,n,r){return t>=r?e.substr(t-r,n-t):e.substr(0,n-t)}function p(e,t,n="source-line-code-issue"){return t.forEach(t=>{const r=[];let s=0,c=t.line!==t.startLine;e.forEach(e=>{const l=(a=s,p=s+e.text.length,d=t.from,m=t.to,{from:Math.max(a,d),to:Math.min(p,m)});var a,p,d,m;const h=u(e.text,s,l.from,s),f=u(e.text,l.from,l.to,s),b=u(e.text,l.to,s+e.text.length,s);if(h.length&&r.push(i({},e,{text:h})),f.length){const s=-1===e.className.indexOf(n)?"".concat(e.className," ").concat(n):e.className;r.push({className:s,markers:c||null==t.index?e.markers:o()([...e.markers,t.index]),text:f}),c=!0}b.length&&r.push(i({},e,{text:b})),s+=e.text.length}),e=r.slice()}),e}},698:function(e,t,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var o in t=arguments[n])Object.prototype.hasOwnProperty.call(t,o)&&(e[o]=t[o]);return e}).apply(this,arguments)},o=this&&this.__rest||function(e,t){var n={};for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&t.indexOf(r)<0&&(n[r]=e[r]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var o=0;for(r=Object.getOwnPropertySymbols(e);o<r.length;o++)t.indexOf(r[o])<0&&Object.prototype.propertyIsEnumerable.call(e,r[o])&&(n[r[o]]=e[r[o]])}return n};Object.defineProperty(t,"__esModule",{value:!0});var s=n(2),i=n(315);t.default=function(e){var t=e.fill,n=void 0===t?"currentColor":t,c=o(e,["fill"]);return s.createElement(i.default,r({},c),s.createElement("g",{fill:"none",fillRule:"evenodd"},s.createElement("path",{d:"M8 1v4H4",stroke:n,strokeWidth:"2",transform:"scale(-.83333 -.84583) rotate(45 7.66 -19.75)"}),s.createElement("path",{d:"M3 5.78h10v1.7H3z",fill:n}),s.createElement("path",{d:"M7.17 2.4h1.66v5.07H7.17z",fill:n}),s.createElement("g",null,s.createElement("path",{d:"M8.16 1.81V6.1H3.9",stroke:n,strokeWidth:"2",transform:"scale(.83333 .84583) rotate(45 -4.2 13.2)"}),s.createElement("path",{d:"M13 10.01H3v-1.7h10z",fill:n}),s.createElement("path",{d:"M8.83 13.4H7.17V9.15h1.66z",fill:n}))))}},709:function(e,t,n){var r=n(640),o=n(673),s=n(674),i=n(353),c=n(643),l=n(641),a=Math.min;e.exports=function(e,t,n){for(var u=n?s:o,p=e[0].length,d=e.length,m=d,h=Array(d),f=1/0,b=[];m--;){var g=e[m];m&&t&&(g=i(g,c(t))),f=a(g.length,f),h[m]=!n&&(t||p>=120&&g.length>=120)?new r(m&&g):void 0}g=e[0];var v=-1,y=h[0];e:for(;++v<p&&b.length<f;){var k=g[v],E=t?t(k):k;if(k=n||0!==k?k:0,!(y?l(y,E):u(b,E,n))){for(m=d;--m;){var j=h[m];if(!(j?l(j,E):u(e[m],E,n)))continue e}y&&y.push(E),b.push(k)}}return b}},710:function(e,t,n){var r=n(444);e.exports=function(e){return r(e)?e:[]}},766:function(e,t,n){"use strict";n.d(t,"a",(function(){return O}));var r=n(311),o=n(2),s=n(316),i=n(312),c=n(369),l=n(698),a=n.n(l),u=n(344),p=n.n(u),d=n(317),m=n.n(d),h=n(31),f=n(391),b=n(343),g=n(327),v=n(321),y=n(337);n(835);function k(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function E(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?k(Object(n),!0).forEach((function(t){j(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):k(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function j(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function O(e){const{branchLike:t,expandable:n,displayProjectName:l=!0,linkToProject:u=!0,loading:d,onExpand:k,sourceViewerFile:j}=e,{measures:O,path:x,project:w,projectName:N,q:P,subProject:L,subProjectName:I}=j,M=o.createElement(o.Fragment,null,o.createElement(p.a,{qualifier:y.a.Project})," ",o.createElement("span",null,N));return o.createElement("div",{className:"source-viewer-header-slim display-flex-row display-flex-space-between"},o.createElement("div",{className:"display-flex-center flex-1"},l&&o.createElement("div",{className:"spacer-right"},u?o.createElement("a",{className:"link-with-icon",href:Object(b.getPathUrlAsString)(Object(v.b)(w,t))},M):M),void 0!==L&&o.createElement(o.Fragment,null,o.createElement(p.a,{qualifier:y.a.SubProject})," ",o.createElement("span",{className:"spacer-right"},I)),o.createElement("div",{className:"spacer-right"},o.createElement(p.a,{qualifier:P})," ",o.createElement("span",null,Object(f.collapsedDirFromPath)(x)),o.createElement("span",{className:"component-name-file"},Object(f.fileFromPath)(x))),o.createElement("div",{className:"spacer-right"},o.createElement(c.ClipboardIconButton,{className:"button-link link-no-underline",copyValue:x}))),void 0!==O.issues&&o.createElement("div",{className:r("flex-0 big-spacer-left",{"little-spacer-right":!n||d})},o.createElement(s.Link,{to:Object(v.h)(w,E({},Object(g.d)(t),{files:x,resolved:"false"}))},Object(h.translate)("source_viewer.view_all_issues"))),n&&o.createElement(m.a,{className:"little-spacer-right",loading:d},o.createElement("div",{className:"flex-0 big-spacer-left"},o.createElement(i.ButtonIcon,{className:"js-actions",onClick:k},o.createElement(a.a,null)))))}},771:function(e,t,n){"use strict";n.d(t,"a",(function(){return s})),n.d(t,"b",(function(){return i})),n.d(t,"c",(function(){return c}));var r=n(653),o=n.n(r);function s(e=[],t=[]){const n=o()(e,t);return n.length?n:void 0}function i(e,t){return null!=e&&t.some(t=>t.index===e.index)?e:void 0}function c(e,t){return void 0!==e&&t.find(t=>t.key===e)?e:void 0}},802:function(e,t,n){"use strict";n.d(t,"a",(function(){return z}));var r=n(838),o=n.n(r),s=n(311),i=n(2),c=(n(839),n(552)),l=n(701),a=n(697),u=n(746);function p(e){const{issuePopup:t}=e;return i.createElement("div",{className:"issue-list"},e.issues.map(n=>i.createElement(u.a,{branchLike:e.branchLike,displayLocationsCount:e.displayIssueLocationsCount,displayLocationsLink:e.displayIssueLocationsLink,issue:n,key:n.key,onChange:e.onIssueChange,onClick:e.onIssueClick,onPopupToggle:e.onIssuePopupToggle,openPopup:t&&t.issue===n.key?t.name:void 0,selected:e.selectedIssue===n.key})))}class d extends i.PureComponent{constructor(e){super(e),this.handleSymbolClick=e=>{e.preventDefault();const t=e.currentTarget.className.match(/sym-\d+/g);t&&t.length>0&&this.props.onSymbolClick(t)},this.state={tokens:Object(a.c)(e.line.code||"")}}componentDidMount(){this.attachEvents(),this.props.highlightedLocationMessage&&this.activeMarkerNode&&this.props.scroll&&this.props.scroll(this.activeMarkerNode)}componentWillReceiveProps(e){e.line.code!==this.props.line.code&&this.setState({tokens:Object(a.c)(e.line.code||"")})}componentWillUpdate(){this.detachEvents()}componentDidUpdate(e){this.attachEvents(),this.props.highlightedLocationMessage&&(!e.highlightedLocationMessage||e.highlightedLocationMessage.index!==this.props.highlightedLocationMessage.index)&&this.activeMarkerNode&&this.props.scroll&&this.props.scroll(this.activeMarkerNode)}componentWillUnmount(){this.detachEvents()}attachEvents(){if(this.codeNode&&(this.symbols=this.codeNode.querySelectorAll(".sym"),this.symbols))for(let e=0;e<this.symbols.length;e++){this.symbols[e].addEventListener("click",this.handleSymbolClick)}}detachEvents(){if(this.symbols)for(let e=0;e<this.symbols.length;e++){this.symbols[e].addEventListener("click",this.handleSymbolClick)}}renderMarker(e,t,n,r){const{onLocationSelect:o}=this.props,s=o?()=>o(e):void 0,a=n?e=>this.activeMarkerNode=e:void 0;return i.createElement(c.a,{key:"marker-".concat(e),leading:r,onClick:s,selected:n},i.createElement("span",{ref:a},e+1),t&&i.createElement(l.a,{selected:!0},t))}render(){const{highlightedLocationMessage:e,highlightedSymbols:t,issues:n,issueLocations:r,line:o,onIssueSelect:c,padding:l,secondaryIssueLocations:u,selectedIssue:d,showIssues:m}=this.props;let h=[...this.state.tokens];if(t&&t.forEach(e=>{h=Object(a.b)(h,e)}),r.length>0&&(h=Object(a.a)(h,r)),u&&(h=Object(a.a)(h,u,"issue-location"),e)){const t=u.find(t=>t.index===e.index);t&&(h=Object(a.a)(h,[t],"selected"))}const f=s("source-line-code","code",{"has-issues":n.length>0}),b=[];let g=!1;h.forEach((t,n)=>{this.props.displayLocationMarkers&&t.markers.length>0&&t.markers.forEach(t=>{const n=void 0!==e&&e.index===t,r=u.find(e=>e.index===t),o=r&&r.text;b.push(this.renderMarker(t,o,n,g))}),b.push(i.createElement("span",{className:t.className,key:n},t.text)),g=(0===n||g)&&!t.text.trim().length});const v=l?{paddingBottom:"".concat(l,"px")}:void 0,y=n.filter(e=>e.key===d);return i.createElement("td",{className:f,"data-line-number":o.line,style:v},i.createElement("div",{className:"source-line-code-inner"},i.createElement("pre",{ref:e=>this.codeNode=e},b)),m&&n.length>0&&i.createElement(p,{branchLike:this.props.branchLike,displayIssueLocationsCount:this.props.displayIssueLocationsCount,displayIssueLocationsLink:this.props.displayIssueLocationsLink,issuePopup:this.props.issuePopup,issues:n,onIssueChange:this.props.onIssueChange,onIssueClick:c,onIssuePopupToggle:this.props.onIssuePopupToggle,selectedIssue:d}),d&&!m&&i.createElement(p,{branchLike:this.props.branchLike,issuePopup:this.props.issuePopup,issues:y,onIssueChange:this.props.onIssueChange,onIssueClick:c,onIssuePopupToggle:this.props.onIssuePopupToggle,selectedIssue:d}))}}var m=n(318),h=n.n(m),f=n(31);var b=i.memo((function({line:e}){const t="source-meta source-line-coverage"+(null!=e.coverageStatus?" source-line-".concat(e.coverageStatus):""),n=function(e){if("uncovered"===e.coverageStatus)return e.conditions?Object(f.translateWithParameters)("source_viewer.tooltip.uncovered.conditions",e.conditions):Object(f.translate)("source_viewer.tooltip.uncovered");if("covered"===e.coverageStatus)return e.conditions?Object(f.translateWithParameters)("source_viewer.tooltip.covered.conditions",e.conditions):Object(f.translate)("source_viewer.tooltip.covered");if("partially-covered"===e.coverageStatus)return e.conditions?Object(f.translateWithParameters)("source_viewer.tooltip.partially-covered.conditions",e.coveredConditions||0,e.conditions):Object(f.translate)("source_viewer.tooltip.partially-covered");return}(e);return i.createElement("td",{className:t,"data-line-number":e.line},i.createElement(h.a,{overlay:n,placement:"right"},i.createElement("div",{"aria-label":n,className:"source-line-bar"})))})),g=n(329),v=n.n(g),y=n(356),k=n.n(y),E=n(370);var j=i.memo((function(e){const{blocksLoaded:t,duplicated:n,index:r,line:o}=e,[c,l]=i.useState(!1),a=s("source-meta","source-line-duplications",{"source-line-duplicated":n});return n?i.createElement("td",{className:a,"data-index":r,"data-line-number":o.line},i.createElement(h.a,{overlay:c?void 0:Object(f.translate)("source_viewer.tooltip.duplicated_block"),placement:"right"},i.createElement("div",null,i.createElement(k.a,{onRequestClose:()=>l(!1),open:c,overlay:i.createElement(g.DropdownOverlay,{placement:E.PopupPlacement.RightTop},e.renderDuplicationPopup(r,o.line))},i.createElement("div",{"aria-label":Object(f.translate)("source_viewer.tooltip.duplicated_block"),className:"source-line-bar",onClick:()=>{l(!0),!t&&o.duplicated&&e.onClick&&e.onClick(o)},role:"button",tabIndex:0}))))):i.createElement("td",{className:a,"data-index":r,"data-line-number":o.line},i.createElement("div",{className:"source-line-bar"}))})),O=n(412),x=n.n(O),w=n(448),N=n.n(w),P=n(545);var L=i.memo((function(e){const{issues:t,issuesOpen:n,line:r}=e,o=t.length>0,c=s("source-meta","source-line-issues",{"source-line-with-issues":o});if(!o)return i.createElement("td",{className:c,"data-line-number":r.line});const l=Object(P.c)(t)[0];let a;return a=x()(t.map(e=>e.type)).length>1?Object(f.translate)("source_viewer.issues_on_line.multiple_issues"):1===t.length?Object(f.translateWithParameters)("source_viewer.issues_on_line.issue_of_type_X",Object(f.translate)("issue.type",l.type)):Object(f.translateWithParameters)("source_viewer.issues_on_line.X_issues_of_type_Y",t.length,Object(f.translate)("issue.type",l.type,"plural")),i.createElement("td",{className:c,"data-line-number":r.line},i.createElement("span",{"aria-label":Object(f.translate)("source_viewer.issues_on_line",n?"hide":"show"),onClick:t=>{t.preventDefault(),t.currentTarget.blur(),e.onClick()},role:"button",tabIndex:0},i.createElement(h.a,{overlay:a},i.createElement(N.a,{type:l.type})),t.length>1&&i.createElement("span",{className:"source-line-issues-counter"},t.length)))})),I=n(316),M=n(321),A=n(651);var C=i.memo((function({line:e}){return i.createElement(A.a.Consumer,null,({branchLike:t,file:n})=>i.createElement("div",{className:"source-viewer-bubble-popup nowrap"},i.createElement(I.Link,{className:"js-get-permalink",rel:"noopener noreferrer",target:"_blank",to:Object(M.d)(n.project,t,n.key,e.line)},Object(f.translate)("component_viewer.get_permalink"))))}));var _=i.memo((function({line:e}){const{line:t}=e;return!!t?i.createElement("td",{className:"source-meta source-line-number","data-line-number":t},i.createElement(v.a,{overlay:i.createElement(C,{line:e}),overlayPlacement:E.PopupPlacement.RightTop},i.createElement("span",{"aria-label":Object(f.translateWithParameters)("source_viewer.line_X",t),role:"button"},t))):i.createElement("td",{className:"source-meta source-line-number"})})),D=n(351),R=n.n(D);var S=i.memo((function({line:e}){const t=void 0!==e.scmAuthor&&""!==e.scmAuthor,n=void 0!==e.scmDate;return i.createElement("div",{className:"source-viewer-bubble-popup abs-width-400"},t&&i.createElement("div",null,i.createElement("h4",null,Object(f.translate)("author")),e.scmAuthor),n&&i.createElement("div",{className:s({"spacer-top":t})},i.createElement("h4",null,Object(f.translate)("source_viewer.tooltip.scm.commited_on")),i.createElement(R.a,{date:e.scmDate})),e.scmRevision&&i.createElement("div",{className:s({"spacer-top":t||n})},i.createElement("h4",null,Object(f.translate)("source_viewer.tooltip.scm.revision")),e.scmRevision))}));var T=i.memo((function({line:e,previousLine:t}){const n=!!e.line,r=i.createElement("div",{className:"source-line-scm-inner"},function(e,t){let n=!0;null!=t&&null!=e.scmRevision&&null!=t.scmRevision&&(n=e.scmRevision!==t.scmRevision||e.scmDate!==t.scmDate);return n}(e,t)?e.scmAuthor||"…":" ");if(n){let t=Object(f.translate)("source_viewer.click_for_scm_info");return e.scmAuthor&&(t="".concat(Object(f.translateWithParameters)("source_viewer.author_X",e.scmAuthor),", ").concat(t)),i.createElement("td",{className:"source-meta source-line-scm","data-line-number":e.line},i.createElement(v.a,{overlay:i.createElement(S,{line:e}),overlayPlacement:E.PopupPlacement.RightTop},i.createElement("div",{"aria-label":t,role:"button"},r)))}return i.createElement("td",{className:"source-meta source-line-scm","data-line-number":e.line},r)}));class z extends i.PureComponent{constructor(){super(...arguments),this.handleIssuesIndicatorClick=()=>{if(this.props.openIssues)this.props.onIssuesClose(this.props.line),this.props.onIssueUnselect();else{this.props.onIssuesOpen(this.props.line);const{issues:e}=this.props;e.length>0&&this.props.onIssueSelect(e[0].key)}}}render(){const{branchLike:e,displayAllIssues:t,displayCoverage:n,displayDuplications:r,displayIssueLocationsCount:c,displayIssueLocationsLink:l,displayLocationMarkers:a,highlightedLocationMessage:u,displayIssues:p,displaySCM:m=!0,duplications:h,duplicationsCount:f,highlighted:g,highlightedSymbols:v,issueLocations:y,issuePopup:k,issues:E,last:O,line:x,openIssues:w,previousLine:N,secondaryIssueLocations:P,selectedIssue:I,verticalBuffer:M}=this.props,A=s("source-line",{"source-line-highlighted":g,"source-line-filtered":x.isNew,"source-line-filtered-dark":n&&("uncovered"===x.coverageStatus||"partially-covered"===x.coverageStatus),"source-line-last":!0===O}),C=M?18*M:void 0;return i.createElement("tr",{className:A,"data-line-number":x.line},i.createElement(_,{line:x}),m&&i.createElement(T,{line:x,previousLine:N}),p&&!t?i.createElement(L,{issues:E,issuesOpen:w,line:x,onClick:this.handleIssuesIndicatorClick}):i.createElement("td",{className:"source-meta source-line-issues"}),r&&i.createElement(j,{blocksLoaded:f>0,duplicated:Boolean(x.duplicated),index:0,key:0,line:this.props.line,onClick:this.props.loadDuplications,renderDuplicationPopup:this.props.renderDuplicationPopup}),f>1&&o()(f-1,e=>i.createElement(j,{blocksLoaded:!0,duplicated:h.includes(e+1),index:e+1,key:e+1,line:this.props.line,renderDuplicationPopup:this.props.renderDuplicationPopup})),n&&i.createElement(b,{line:x}),i.createElement(d,{branchLike:e,displayIssueLocationsCount:c,displayIssueLocationsLink:l,displayLocationMarkers:a,highlightedLocationMessage:u,highlightedSymbols:v,issueLocations:y,issuePopup:k,issues:E,line:x,onIssueChange:this.props.onIssueChange,onIssuePopupToggle:this.props.onIssuePopupToggle,onIssueSelect:this.props.onIssueSelect,onLocationSelect:this.props.onLocationSelect,onSymbolClick:this.props.onSymbolClick,padding:C,scroll:this.props.scroll,secondaryIssueLocations:P,selectedIssue:I,showIssues:w||t}))}}},835:function(e,t,n){var r=n(313),o=n(836);"string"==typeof(o=o.__esModule?o.default:o)&&(o=[[e.i,o,""]]);var s={insert:"head",singleton:!1},i=(r(o,s),o.locals?o.locals:{});e.exports=i},836:function(e,t,n){(t=n(314)(!1)).push([e.i,".source-viewer-header-slim{padding:4px 10px;border-bottom:1px solid #cdcdcd;background-color:#f3f3f3;align-items:center;min-height:25px}",""]),e.exports=t},838:function(e,t){e.exports=function(e,t){for(var n=-1,r=Array(e);++n<e;)r[n]=t(n);return r}},839:function(e,t,n){var r=n(313),o=n(840);"string"==typeof(o=o.__esModule?o.default:o)&&(o=[[e.i,o,""]]);var s={insert:"head",singleton:!1},i=(r(o,s),o.locals?o.locals:{});e.exports=i},840:function(e,t,n){(t=n(314)(!1)).push([e.i,'.source-line:hover .source-line-coverage,.source-line:hover .source-line-duplications,.source-line:hover .source-line-duplications-extra,.source-line:hover .source-line-issues,.source-line:hover .source-line-number,.source-line:hover .source-line-scm{border-color:#e9e9e9;background-color:#e9e9e9}.source-line:hover .source-line-code{background-color:#f5f5f5}.source-line [role=button]{cursor:pointer}.source-line-highlighted .source-line-coverage,.source-line-highlighted .source-line-duplications,.source-line-highlighted .source-line-duplications-extra,.source-line-highlighted .source-line-issues,.source-line-highlighted .source-line-number,.source-line-highlighted .source-line-scm,.source-line-highlighted:hover .source-line-coverage,.source-line-highlighted:hover .source-line-duplications,.source-line-highlighted:hover .source-line-duplications-extra,.source-line-highlighted:hover .source-line-issues,.source-line-highlighted:hover .source-line-number,.source-line-highlighted:hover .source-line-scm{border-color:#c4dfec!important;background-color:#c4dfec}.source-line-highlighted .source-line-code,.source-line-highlighted:hover .source-line-code{background-color:#d9edf7}.source-line-filtered .source-line-code{background-color:#fbf3d5!important}.source-line-filtered.source-line-highlighted .source-line-code,.source-line-filtered.source-line-highlighted:hover .source-line-code{background-color:#cdd9c4!important}.source-line-filtered.source-line-filtered-dark .source-line-code{background-color:#f9ebb7!important}.source-line-filtered.source-line-filtered-dark:hover .source-line-code,.source-line-filtered:hover .source-line-code{background-color:#f1e8cb!important}.source-line-last .source-line-code{padding-bottom:160px}.source-viewer pre{height:18px;padding:0}.source-line-number,.source-line-scm,.source-viewer pre{line-height:18px;font-family:Consolas,Liberation Mono,Menlo,Courier,monospace;font-size:12px}.source-line-code{position:relative;padding:0 10px}.source-line-code pre{float:left}.source-line-code .issue-list{margin-left:-10px;margin-right:-10px}.source-line-code-inner{min-height:18px}.source-line-code-inner:after,.source-line-code-inner:before{display:table;content:"";line-height:0}.source-line-code-inner:after{clear:both}.source-line-code-inner pre{-moz-tab-size:4;tab-size:4}.source-line-code-issue{display:inline-block;background-image:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAcAAAAGCAYAAAAPDoR2AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo1M0M2Rjk4M0M3QUYxMUUzODkzRUREMUM5OTNDMjY4QSIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDo1M0M2Rjk4NEM3QUYxMUUzODkzRUREMUM5OTNDMjY4QSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjUzQzZGOTgxQzdBRjExRTM4OTNFREQxQzk5M0MyNjhBIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOjUzQzZGOTgyQzdBRjExRTM4OTNFREQxQzk5M0MyNjhBIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+bcqJtQAAAEhJREFUeNpi+G+swwDGDAwgbAWlwZiJAQFCgfgwEIfDRaC67ID4NRDnQ2kQnwFZwgFqnANMAQOUYY9sF0wBiCGH5CBkrAgQYACuWi4sSGW8yAAAAABJRU5ErkJggg==);background-repeat:repeat-x;background-size:4px;background-position:bottom}.source-meta{position:relative;vertical-align:top;width:1px;background-clip:padding-box;-webkit-user-select:none;-ms-user-select:none;user-select:none}.source-meta:focus{outline:none}.source-line-number{min-width:18px;padding:0 10px;background-color:#f3f3f3;color:#777;text-align:right}.source-line-issues{position:relative;padding:0 2px;background-color:#f3f3f3;white-space:nowrap}.source-line-with-issues svg{padding-right:2px;vertical-align:middle}.source-line-issues-counter{position:absolute;left:17px;line-height:8px;font-size:8px;z-index:900}.source-line-coverage,.source-line-duplications,.source-line-duplications-extra{background-color:#f3f3f3}.source-line-duplications-extra{display:none}.source-line-scm{padding:0 5px;background-color:#f3f3f3}.source-line-scm .dropdown{display:block}.source-line-scm [role=button]{height:18px}.source-line-scm-inner{max-width:40px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap}.source-line-bar{width:5px;height:18px}.source-line-bar:focus{outline:none}.source-line-covered{background-color:#b4dd78!important}.source-line-partially-covered,.source-line-uncovered{background-color:#a4030f!important}.source-line-partially-covered{background-image:repeating-linear-gradient(45deg,hsla(0,0%,100%,.5) 4px,transparent 0,transparent 8px,hsla(0,0%,100%,.5) 0,hsla(0,0%,100%,.5) 12px,transparent 0,transparent 16px,hsla(0,0%,100%,.5) 0,hsla(0,0%,100%,.5) 20px)!important}.source-line-duplicated{background-color:#797979!important}',""]),e.exports=t}}]);
//# sourceMappingURL=8.m.df0183fe.chunk.js.map