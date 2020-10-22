(window.webpackJsonp=window.webpackJsonp||[]).push([[293],{1671:function(e,t,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var a in t=arguments[n])Object.prototype.hasOwnProperty.call(t,a)&&(e[a]=t[a]);return e}).apply(this,arguments)},a=this&&this.__rest||function(e,t){var n={};for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&t.indexOf(r)<0&&(n[r]=e[r]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var a=0;for(r=Object.getOwnPropertySymbols(e);a<r.length;a++)t.indexOf(r[a])<0&&Object.prototype.propertyIsEnumerable.call(e,r[a])&&(n[r[a]]=e[r[a]])}return n};Object.defineProperty(t,"__esModule",{value:!0});var l=n(2),i=n(315);t.default=function(e){var t=e.fill,n=void 0===t?"currentColor":t,s=a(e,["fill"]);return l.createElement(i.default,r({},s),l.createElement("path",{d:"M5.273 7.182v1.636a.818.818 0 0 1-.818.818H2.818A.818.818 0 0 1 2 8.818V7.182c0-.452.366-.818.818-.818h1.637c.451 0 .818.366.818.818zm4.363 0v1.636a.818.818 0 0 1-.818.818H7.182a.818.818 0 0 1-.818-.818V7.182c0-.452.366-.818.818-.818h1.636c.452 0 .818.366.818.818zm4.364 0v1.636a.818.818 0 0 1-.818.818h-1.637a.818.818 0 0 1-.818-.818V7.182c0-.452.367-.818.818-.818h1.637c.452 0 .818.366.818.818z",style:{fill:n}}))}},1672:function(e,t,n){var r=n(313),a=n(1673);"string"==typeof(a=a.__esModule?a.default:a)&&(a=[[e.i,a,""]]);var l={insert:"head",singleton:!1},i=(r(a,l),a.locals?a.locals:{});e.exports=i},1673:function(e,t,n){(t=n(314)(!1)).push([e.i,".marketplace-editions{display:flex;flex-direction:row;margin-left:-8px;margin-right:-8px}.marketplace-edition{position:relative;flex:1;display:flex;flex-direction:column;justify-content:space-between;margin-left:8px;margin-right:8px;max-width:50%}.marketplace-edition .markdown img{width:16px}.marketplace-edition .markdown h3{font-size:14px;margin-top:0}.marketplace-edition-badge{position:absolute;right:-1px;top:16px;padding:4px 8px;border-radius:2px 0 0 2px;height:inherit;line-height:inherit}.marketplace-edition-action{display:flex;align-items:baseline;justify-content:space-between}.marketplace-plugin-table{table-layout:fixed;width:100%}.marketplace-plugin-license{overflow:hidden;text-overflow:ellipsis;white-space:nowrap}",""]),e.exports=t},1839:function(e,t,n){"use strict";n.r(t);var r=n(2),a=n(323),l=n(712),i=n(325),s=n(527),o=n.n(s),c=n(328),u=n.n(c),p=n(332),d=n(317),m=n.n(d),g=n(31),h=n(608),b=n(335),f=n(364),v=n(549),E=n(757),y=n(331);const O=Object(y.lazyLoadComponent)(()=>Promise.all([n.e(6),n.e(349)]).then(n.bind(null,1153)),"DocMarkdownBlock");function k({edition:e,ncloc:t,serverId:n,currentEdition:a}){return r.createElement("div",{className:"boxed-group boxed-group-inner marketplace-edition"},"datacenter"===e.key&&r.createElement(O,{content:"### ![SonarQube logo](/images/sonarqube-icon.png) Data Center Edition\n\n*Designed for High Availability and Scalability*\n\nEnterprise Edition functionality plus:\n\n* Component redundancy\n* Data resiliency\n* Horizontal scalability\n"}),"developer"===e.key&&r.createElement(O,{content:"### ![SonarQube logo](/images/sonarqube-icon.png) Developer Edition\n\n*Built for Developers by Developers*\n\nCommunity Edition functionality plus:\n\n* Branch analysis\n* Pull Request Decoration\n* Injection flaw detection\n* SonarLint notifications\n* Additional language analysis: C, C++, Obj-C, PS/SQL, ABAP, TSQL & Swift\n"}),"enterprise"===e.key&&r.createElement(O,{content:"### ![SonarQube logo](/images/sonarqube-icon.png) Enterprise Edition\n\n*Designed to Meet Enterprise Requirements*\n\nDeveloper Edition functionality plus:\n\n* Portfolio management\n* OWASP/SANS security reports\n* Executive reporting\n* Project transfer\n* Compute Engine parallel processing\n* Additional language analysis: Apex, COBOL, PL/I, RPG & VB6\n"}),r.createElement("div",{className:"marketplace-edition-action spacer-top"},r.createElement("a",{href:Object(E.e)(e,{ncloc:t,serverId:n,sourceEdition:a}),rel:"noopener noreferrer",target:"_blank"},Object(g.translate)("marketplace.request_free_trial"))))}function j(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function x(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}class P extends r.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={},this.fetchData=()=>{Object(v.b)().then(e=>{this.mounted&&this.setState(function(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?j(Object(n),!0).forEach((function(t){x(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):j(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}({},e))},()=>{})}}componentDidMount(){this.mounted=!0,this.fetchData()}componentWillUnmount(){this.mounted=!1}render(){const{currentEdition:e}=this.props,{serverId:t,ncloc:n}=this.state,a=Object(E.a)(e);return a.length<=0?null:r.createElement("div",{className:"spacer-bottom marketplace-editions"},a.map(a=>r.createElement(k,{currentEdition:e,edition:a,key:a.key,ncloc:n,serverId:t})))}}function _({total:e}){return r.createElement("footer",{className:"spacer-top note text-center"},Object(g.translateWithParameters)("x_show",e))}function N({currentEdition:e}){return r.createElement("header",{className:"page-header",id:"marketplace-header"},r.createElement("h1",{className:"page-title"},Object(g.translate)("marketplace.page")),e&&r.createElement("h3",{className:"page-description"},Object(g.translate)("marketplace.page.you_are_running",e)),r.createElement("p",{className:"page-description"},"datacenter"===e?Object(g.translate)("marketplace.page.description_best_edition"):Object(g.translate)("marketplace.page.description")))}var w=n(577),C=n(312),S=n(329),D=n.n(S),A=n(1671),U=n.n(A),M=n(318),q=n.n(M),z=n(351),B=n.n(z);function L({release:e,update:t}){return r.createElement("li",{className:"big-spacer-bottom"},r.createElement("div",{className:"little-spacer-bottom"},"COMPATIBLE"!==t.status&&t.status?r.createElement(q.a,{overlay:Object(g.translate)("marketplace.update_status",t.status)},r.createElement("span",{className:"js-plugin-changelog-version badge badge-warning spacer-right"},e.version)):r.createElement("span",{className:"js-plugin-changelog-version badge badge-success spacer-right"},e.version),r.createElement("span",{className:"js-plugin-changelog-date note spacer-right"},r.createElement(B.a,{date:e.date})),e.changeLogUrl&&r.createElement("a",{className:"js-plugin-changelog-link",href:e.changeLogUrl,target:"_blank",rel:"noopener noreferrer"},Object(g.translate)("marketplace.release_notes"))),r.createElement("div",{className:"js-plugin-changelog-description"},e.description))}function T({release:e,update:t}){return r.createElement("div",{className:"abs-width-300"},r.createElement("h6",null,Object(g.translate)("changelog")),r.createElement("ul",{className:"js-plugin-changelog-list"},t.previousUpdates&&t.previousUpdates.map(e=>e.release?r.createElement(L,{key:e.release.version,release:e.release,update:e}):null),r.createElement(L,{release:e,update:t})))}function I({release:e,update:t}){return r.createElement(D.a,{className:"display-inline-block little-spacer-left",overlay:r.createElement(T,{release:e,update:t})},r.createElement(C.ButtonLink,{className:"js-changelog"},r.createElement(U.a,null)))}var Q=e=>r.createElement("td",{className:"text-top width-25 big-spacer-right"},r.createElement("div",null,r.createElement("strong",{className:"js-plugin-name"},e.plugin.name),e.plugin.category&&r.createElement("span",{className:"js-plugin-category badge spacer-left"},e.plugin.category)),r.createElement("div",{className:"js-plugin-description little-spacer-top"},e.plugin.description)),F=n(319);function R({license:e}){return e?r.createElement(q.a,{overlay:e},r.createElement("li",{className:"little-spacer-bottom marketplace-plugin-license"},r.createElement(F.FormattedMessage,{defaultMessage:Object(g.translate)("marketplace.licensed_under_x"),id:"marketplace.licensed_under_x",values:{license:r.createElement("span",{className:"js-plugin-license"},e)}}))):null}function J({plugin:e}){return e.organizationName?r.createElement("li",{className:"little-spacer-bottom"},r.createElement(F.FormattedMessage,{defaultMessage:Object(g.translate)("marketplace.developed_by_x"),id:"marketplace.developed_by_x",values:{organization:e.organizationUrl?r.createElement("a",{className:"js-plugin-organization",href:e.organizationUrl,target:"_blank",rel:"noopener noreferrer"},e.organizationName):r.createElement("span",{className:"js-plugin-organization"},e.organizationName)}})):null}var W=n(341),V=n.n(W),H=n(509),G=n.n(H);class Y extends r.PureComponent{constructor(){super(...arguments),this.handleClick=()=>{this.props.onClick(this.props.update)}}render(){const{disabled:e,update:t}=this.props;return"COMPATIBLE"===t.status&&t.release?r.createElement(q.a,{overlay:Object(g.translate)("marketplace.requires_restart")},r.createElement(C.Button,{className:"js-update little-spacer-bottom",disabled:e,onClick:this.handleClick},Object(g.translateWithParameters)("marketplace.update_to_x",t.release.version))):null}}class X extends r.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={acceptTerms:!1,loading:!1},this.doPluginAction=e=>{this.setState({loading:!0}),e({key:this.props.plugin.key}).then(()=>{this.props.refreshPending(),this.mounted&&this.setState({loading:!1})},()=>{this.mounted&&this.setState({loading:!1})})},this.handleInstall=()=>this.doPluginAction(h.g),this.handleUpdate=()=>this.doPluginAction(h.i),this.handleUninstall=()=>this.doPluginAction(h.h),this.handleTermsCheck=e=>this.setState({acceptTerms:e})}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}renderBundled(){const{plugin:e}=this.props;return r.createElement("div",{className:"js-actions"},Object(w.b)(e)&&r.createElement("div",null,r.createElement("p",{className:"little-spacer-bottom"},Object(g.translate)("marketplace.available_under_commercial_license")),r.createElement("a",{href:e.homepageUrl,target:"_blank",rel:"noopener noreferrer"},Object(g.translate)("marketplace.learn_more"))),Object(w.c)(e)&&r.createElement("p",null,r.createElement(G.a,{className:"little-spacer-right"}),Object(g.translate)("marketplace.installed")),Object(w.c)(e)&&e.updates&&e.updates.length>0&&r.createElement("div",{className:"spacer-top"},e.updates.map((e,t)=>r.createElement(Y,{disabled:this.state.loading,key:t,onClick:this.handleUpdate,update:e}))))}render(){const{plugin:e}=this.props;if(e.editionBundled)return this.renderBundled();const{loading:t}=this.state;return r.createElement("div",{className:"js-actions"},Object(w.b)(e)&&e.termsAndConditionsUrl&&r.createElement("p",{className:"little-spacer-bottom"},r.createElement(V.a,{checked:this.state.acceptTerms,className:"js-terms",id:"plugin-terms-"+e.key,onCheck:this.handleTermsCheck},r.createElement("label",{className:"little-spacer-left",htmlFor:"plugin-terms-"+e.key},Object(g.translate)("marketplace.i_accept_the"))),r.createElement("a",{className:"js-plugin-terms nowrap little-spacer-left",href:e.termsAndConditionsUrl,target:"_blank",rel:"noopener noreferrer"},Object(g.translate)("marketplace.terms_and_conditions"))),t&&r.createElement("i",{className:"spinner spacer-right little-spacer-top little-spacer-bottom"}),Object(w.c)(e)&&r.createElement(r.Fragment,null,e.updates&&e.updates.map((e,n)=>r.createElement(Y,{disabled:t,key:n,onClick:this.handleUpdate,update:e})),r.createElement(q.a,{overlay:Object(g.translate)("marketplace.requires_restart")},r.createElement(C.Button,{className:"js-uninstall button-red little-spacer-left",disabled:t,onClick:this.handleUninstall},Object(g.translate)("marketplace.uninstall")))),Object(w.b)(e)&&r.createElement(q.a,{overlay:Object(g.translate)("marketplace.requires_restart")},r.createElement(C.Button,{className:"js-install",disabled:t||null!=e.termsAndConditionsUrl&&!this.state.acceptTerms,onClick:this.handleInstall},Object(g.translate)("marketplace.install"))))}}function K({plugin:e,refreshPending:t,status:n}){return r.createElement("td",{className:"text-top text-right width-20 little-spacer-left"},"installing"===n&&r.createElement("p",{className:"text-success"},Object(g.translate)("marketplace.install_pending")),"updating"===n&&r.createElement("p",{className:"text-success"},Object(g.translate)("marketplace.update_pending")),"removing"===n&&r.createElement("p",{className:"text-danger"},Object(g.translate)("marketplace.uninstall_pending")),null==n&&r.createElement(X,{plugin:e,refreshPending:t}))}function Z({plugin:e}){return e.homepageUrl||e.issueTrackerUrl?r.createElement("li",{className:"little-spacer-bottom"},r.createElement("ul",{className:"list-inline"},e.homepageUrl&&r.createElement("li",null,r.createElement("a",{className:"js-plugin-homepage",href:e.homepageUrl,target:"_blank",rel:"noopener noreferrer"},Object(g.translate)("marketplace.homepage"))),e.issueTrackerUrl&&r.createElement("li",null,r.createElement("a",{className:"js-plugin-issues",href:e.issueTrackerUrl,target:"_blank",rel:"noopener noreferrer"},Object(g.translate)("marketplace.issue_tracker"))))):null}function $(e){const{installedPlugins:t,plugin:n,readOnly:a,status:l}=e,i=t.map(({key:e})=>e);return r.createElement("tr",null,r.createElement(Q,{plugin:n}),r.createElement("td",{className:"text-top big-spacer-right"},r.createElement("ul",null,r.createElement("li",{className:"display-flex-row little-spacer-bottom"},r.createElement("div",{className:"pull-left spacer-right"},r.createElement("span",{className:"badge badge-success"},n.release.version)),r.createElement("div",null,n.release.description,r.createElement(I,{release:n.release,update:n.update}),n.update.requires.length>0&&r.createElement("p",{className:"little-spacer-top"},r.createElement("strong",null,Object(g.translateWithParameters)("marketplace.installing_this_plugin_will_also_install_x",n.update.requires.filter(({key:e})=>!i.includes(e)).map(e=>e.name).join(", ")))))))),r.createElement("td",{className:"text-top width-20"},r.createElement("ul",null,r.createElement(Z,{plugin:n}),r.createElement(R,{license:n.license}),r.createElement(J,{plugin:n}))),!a&&r.createElement(K,{plugin:n,refreshPending:e.refreshPending,status:l}))}class ee extends r.PureComponent{constructor(){super(...arguments),this.state={changelogOpen:!1},this.handleChangelogClick=e=>{e.preventDefault(),e.stopPropagation(),this.toggleChangelog()},this.toggleChangelog=e=>{void 0!==e?this.setState({changelogOpen:e}):this.setState(e=>({changelogOpen:!e.changelogOpen}))}}render(){const{release:e,update:t}=this.props;return r.createElement("li",{className:"display-flex-row little-spacer-bottom",key:e.version},r.createElement("div",{className:"pull-left spacer-right"},"COMPATIBLE"===t.status?r.createElement("span",{className:"js-update-version badge badge-success"},e.version):r.createElement(q.a,{overlay:Object(g.translate)("marketplace.update_status",t.status)},r.createElement("span",{className:"js-update-version badge badge-warning"},e.version))),r.createElement("div",null,e.description,r.createElement(I,{release:e,update:t})))}}function te({updates:e}){return!e||e.length<=0?null:r.createElement("li",{className:"spacer-top"},r.createElement("strong",null,Object(g.translate)("marketplace.updates"),":"),r.createElement("ul",{className:"little-spacer-top"},e.map(e=>e.release?r.createElement(ee,{key:e.release.version,release:e.release,update:e}):null)))}function ne({plugin:e,readOnly:t,refreshPending:n,status:a}){return r.createElement("tr",null,r.createElement(Q,{plugin:e}),r.createElement("td",{className:"text-top big-spacer-right"},r.createElement("ul",null,r.createElement("li",{className:"little-spacer-bottom"},r.createElement("strong",{className:"js-plugin-installed-version little-spacer-right"},e.version),Object(g.translate)("marketplace._installed")),r.createElement(te,{updates:e.updates}))),r.createElement("td",{className:"text-top width-20"},r.createElement("ul",null,r.createElement(Z,{plugin:e}),r.createElement(R,{license:e.license}),r.createElement(J,{plugin:e}))),!t&&r.createElement(K,{plugin:e,refreshPending:n,status:a}))}function re(e,t){const{installing:n,updating:r,removing:a}=t;return n.find(t=>t.key===e.key)?"installing":r.find(t=>t.key===e.key)?"updating":a.find(t=>t.key===e.key)?"removing":void 0}function ae(e){const{pending:t,plugins:n,readOnly:a}=e,l=n.filter(w.c);return r.createElement("div",{className:"boxed-group boxed-group-inner",id:"marketplace-plugins"},r.createElement("ul",null,u()(n,({name:e})=>e).map(n=>r.createElement("li",{className:"panel panel-vertical",key:n.key},r.createElement("table",{className:"marketplace-plugin-table"},r.createElement("tbody",null,Object(w.c)(n)&&r.createElement(ne,{plugin:n,readOnly:a,refreshPending:e.refreshPending,status:re(n,t)}),Object(w.b)(n)&&r.createElement($,{installedPlugins:l,plugin:n,readOnly:a,refreshPending:e.refreshPending,status:re(n,t)})))))))}var le=n(392),ie=n.n(le),se=n(350),oe=n.n(se);class ce extends r.PureComponent{constructor(){super(...arguments),this.handleSearch=e=>{this.props.updateQuery({search:e})},this.handleFilterChange=e=>this.props.updateQuery({filter:e})}render(){const{query:e,updateCenterActive:t}=this.props,n=[{label:Object(g.translate)("marketplace.all"),value:"all"},{label:Object(g.translate)("marketplace.installed"),value:"installed"},{disabled:!t,label:Object(g.translate)("marketplace.updates_only"),tooltip:t?void 0:Object(g.translate)("marketplace.not_activated"),value:"updates"}];return r.createElement("div",{className:"big-spacer-bottom",id:"marketplace-search"},r.createElement("div",{className:"display-inline-block text-top nowrap abs-width-240 spacer-right"},r.createElement(ie.a,{name:"marketplace-filter",onCheck:this.handleFilterChange,options:n,value:e.filter})),r.createElement(oe.a,{onChange:this.handleSearch,placeholder:Object(g.translate)("marketplace.search"),value:e.search}))}}n(1672);var ue=n(571),pe=n.n(ue),de=n(471);const me=["license"];const ge=pe()(e=>({filter:Object(de.parseAsString)(e.filter)||"all",search:Object(de.parseAsString)(e.search)})),he=pe()(e=>Object(de.cleanQuery)({filter:"all"===e.filter?void 0:Object(de.serializeString)(e.filter),search:e.search?Object(de.serializeString)(e.search):void 0}));function be(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function fe(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}class ve extends r.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loadingPlugins:!0,plugins:[]},this.fetchQueryPlugins=()=>{const e=ge(this.props.location.query);let t=this.fetchAllPlugins;"updates"===e.filter?t=h.f:"installed"===e.filter&&(t=h.c),this.setState({loadingPlugins:!0}),t().then(e=>{this.mounted&&this.setState({loadingPlugins:!1,plugins:u()(e,"name")})},this.stopLoadingPlugins)},this.fetchAllPlugins=()=>Promise.all([Object(h.d)(),Object(h.b)()]).then(([e,t])=>o()([...e,...t.plugins],"key"),this.stopLoadingPlugins),this.updateQuery=e=>{const t=he(function(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?be(Object(n),!0).forEach((function(t){fe(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):be(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}({},ge(this.props.location.query),{},e));this.props.router.push({pathname:this.props.location.pathname,query:t})},this.stopLoadingPlugins=()=>{this.mounted&&this.setState({loadingPlugins:!1})}}componentDidMount(){this.mounted=!0,this.fetchQueryPlugins()}componentDidUpdate(e){e.location.query.filter!==this.props.location.query.filter&&this.fetchQueryPlugins()}componentWillUnmount(){this.mounted=!1}render(){const{currentEdition:e,standaloneMode:t,pendingPlugins:n}=this.props,{loadingPlugins:a,plugins:l}=this.state,i=ge(this.props.location.query),s=function(e,t){if(!t)return e.filter(e=>!me.includes(e.key));const n=t.toLowerCase();return e.filter(e=>!me.includes(e.key)&&(e.name.toLowerCase().includes(n)||(e.description||"").toLowerCase().includes(n)||(e.category||"").toLowerCase().includes(n)))}(l,i.search);return r.createElement("div",{className:"page page-limited",id:"marketplace-page"},r.createElement(b.a,{suggestions:"marketplace"}),r.createElement(p.a,{title:Object(g.translate)("marketplace.page")}),r.createElement(N,{currentEdition:e}),r.createElement(P,{currentEdition:e}),r.createElement("header",{className:"page-header"},r.createElement("h1",{className:"page-title"},Object(g.translate)("marketplace.page.plugins")),r.createElement("div",{className:"page-description"},Object(g.translate)("marketplace.page.plugins.description"))),r.createElement(ce,{query:i,updateCenterActive:this.props.updateCenterActive,updateQuery:this.updateQuery}),r.createElement(m.a,{loading:a},0===s.length&&Object(g.translate)("marketplace.plugin_list.no_plugins",i.filter),s.length>0&&r.createElement(r.Fragment,null,r.createElement(ae,{pending:n,plugins:s,readOnly:!t,refreshPending:this.props.fetchPendingPlugins}),r.createElement(_,{total:s.length}))))}}var Ee=Object(f.a)(ve);t.default=Object(a.connect)(e=>{const t=Object(i.getGlobalSettingValue)(e,"sonar.updatecenter.activate");return{currentEdition:Object(i.getAppState)(e).edition,standaloneMode:Object(i.getAppState)(e).standalone,updateCenterActive:Boolean(t&&"true"===t.value)}})(e=>r.createElement(l.a.Consumer,null,({fetchPendingPlugins:t,pendingPlugins:n})=>r.createElement(Ee,Object.assign({fetchPendingPlugins:t,pendingPlugins:n},e))))},335:function(e,t,n){"use strict";n.d(t,"a",(function(){return l}));var r=n(2),a=n(368);function l({suggestions:e}){return r.createElement(a.a.Consumer,null,({addSuggestions:t,removeSuggestions:n})=>r.createElement(i,{addSuggestions:t,removeSuggestions:n,suggestions:e}))}class i extends r.PureComponent{componentDidMount(){this.props.addSuggestions(this.props.suggestions)}componentDidUpdate(e){e.suggestions!==this.props.suggestions&&(this.props.removeSuggestions(this.props.suggestions),this.props.addSuggestions(e.suggestions))}componentWillUnmount(){this.props.removeSuggestions(this.props.suggestions)}render(){return null}}},341:function(e,t,n){"use strict";var r,a=this&&this.__extends||(r=function(e,t){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}r(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)});Object.defineProperty(t,"__esModule",{value:!0});var l=n(311),i=n(2),s=n(317);n(361);var o=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.handleClick=function(e){e.preventDefault(),e.currentTarget.blur(),t.props.disabled||t.props.onCheck(!t.props.checked,t.props.id)},t}return a(t,e),t.prototype.render=function(){var e=this.props,t=e.checked,n=e.children,r=e.disabled,a=e.id,o=e.loading,c=e.right,u=e.thirdState,p=e.title,d=l("icon-checkbox",{"icon-checkbox-checked":t,"icon-checkbox-single":u,"icon-checkbox-disabled":r});return n?i.createElement("a",{"aria-checked":t,className:l("link-checkbox",this.props.className,{note:r,disabled:r}),href:"#",id:a,onClick:this.handleClick,role:"checkbox",title:p},c&&n,i.createElement(s.default,{loading:Boolean(o)},i.createElement("i",{className:d})),!c&&n):o?i.createElement(s.default,null):i.createElement("a",{"aria-checked":t,className:l(d,this.props.className),href:"#",id:a,onClick:this.handleClick,role:"checkbox",title:p})},t.defaultProps={thirdState:!1},t}(i.PureComponent);t.default=o},351:function(e,t,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var a in t=arguments[n])Object.prototype.hasOwnProperty.call(t,a)&&(e[a]=t[a]);return e}).apply(this,arguments)};Object.defineProperty(t,"__esModule",{value:!0});var a=n(2),l=n(319),i=n(26);t.formatterOption={year:"numeric",month:"short",day:"2-digit"},t.longFormatterOption={year:"numeric",month:"long",day:"numeric"},t.default=function(e){var n=e.children,s=e.date,o=e.long;return a.createElement(l.FormattedDate,r({value:i.parseDate(s)},o?t.longFormatterOption:t.formatterOption),n)}},358:function(e,t){e.exports=function(e){return e}},361:function(e,t,n){var r=n(313),a=n(362);"string"==typeof(a=a.__esModule?a.default:a)&&(a=[[e.i,a,""]]);var l={insert:"head",singleton:!1},i=(r(a,l),a.locals?a.locals:{});e.exports=i},362:function(e,t,n){(t=n(314)(!1)).push([e.i,".icon-checkbox{display:inline-block;line-height:1;vertical-align:top;padding:1px 2px;box-sizing:border-box}a.icon-checkbox{border-bottom:none}.icon-checkbox:focus{outline:none}.icon-checkbox:before{content:\" \";display:inline-block;width:10px;height:10px;border:1px solid #236a97;border-radius:2px;transition:border-color .2s ease,background-color .2s ease,background-image .2s ease,box-shadow .4s ease}.icon-checkbox:not(.icon-checkbox-disabled):focus:before,.link-checkbox:not(.disabled):focus:focus .icon-checkbox:before{box-shadow:0 0 0 3px rgba(35,106,151,.25)}.icon-checkbox-checked:before{background-color:#4b9fd5;background-image:url(\"data:image/svg+xml;charset=utf-8,%3Csvg viewBox='0 0 14 14' xmlns='http://www.w3.org/2000/svg' fill-rule='evenodd' clip-rule='evenodd' stroke-linejoin='round' stroke-miterlimit='1.414'%3E%3Cpath d='M12 4.665c0 .172-.06.318-.18.438l-5.55 5.55c-.12.12-.266.18-.438.18s-.318-.06-.438-.18L2.18 7.438C2.06 7.317 2 7.17 2 7s.06-.318.18-.44l.878-.876c.12-.12.267-.18.44-.18.17 0 .317.06.437.18l1.897 1.903 4.233-4.24c.12-.12.266-.18.438-.18s.32.06.44.18l.876.88c.12.12.18.265.18.438z' fill='%23fff' fill-rule='nonzero'/%3E%3C/svg%3E\");border-color:#4b9fd5}.icon-checkbox-checked.icon-checkbox-single:before{background-image:url(\"data:image/svg+xml;charset=utf-8,%3Csvg viewBox='0 0 14 14' xmlns='http://www.w3.org/2000/svg' fill-rule='evenodd' clip-rule='evenodd' stroke-linejoin='round' stroke-miterlimit='1.414'%3E%3Cpath d='M10 4.698A.697.697 0 0 0 9.302 4H4.698A.697.697 0 0 0 4 4.698v4.604c0 .386.312.698.698.698h4.604A.697.697 0 0 0 10 9.302V4.698z' fill='%23fff'/%3E%3C/svg%3E\")}.icon-checkbox-disabled:before{border:1px solid #bbb;cursor:not-allowed}.icon-checkbox-disabled.icon-checkbox-checked:before{background-color:#bbb}.icon-checkbox-invisible{visibility:hidden}.link-checkbox{color:inherit;border-bottom:none}.link-checkbox.disabled,.link-checkbox.disabled:hover,.link-checkbox.disabled label{color:#777;cursor:not-allowed}.link-checkbox:active,.link-checkbox:focus,.link-checkbox:hover{color:inherit}",""]),e.exports=t},382:function(e,t,n){var r=n(358);e.exports=function(e){var t=r(e),n=t%1;return t==t?n?t-n:t:0}},392:function(e,t,n){"use strict";var r,a=this&&this.__extends||(r=function(e,t){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}r(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)});Object.defineProperty(t,"__esModule",{value:!0});var l=n(311),i=n(2);n(410);var s=n(318),o=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.renderOption=function(e){var n=e.value===t.props.value,r=t.props.name+"__"+e.value;return i.createElement("li",{key:e.value.toString()},i.createElement("input",{checked:n,disabled:e.disabled,id:r,name:t.props.name,onChange:function(){return t.props.onCheck(e.value)},type:"radio"}),i.createElement(s.default,{overlay:e.tooltip||void 0},i.createElement("label",{htmlFor:r},e.label)))},t}return a(t,e),t.prototype.render=function(){return i.createElement("ul",{className:l("radio-toggle",this.props.className)},this.props.options.map(this.renderOption))},t.defaultProps={disabled:!1,value:null},t}(i.PureComponent);t.default=o},410:function(e,t,n){var r=n(313),a=n(411);"string"==typeof(a=a.__esModule?a.default:a)&&(a=[[e.i,a,""]]);var l={insert:"head",singleton:!1},i=(r(a,l),a.locals?a.locals:{});e.exports=i},411:function(e,t,n){(t=n(314)(!1)).push([e.i,".radio-toggle{font-size:0;white-space:nowrap}.radio-toggle,.radio-toggle>li{display:inline-block;vertical-align:middle}.radio-toggle>li{font-size:12px}.radio-toggle>li:first-child>label{border-top-left-radius:2px;border-bottom-left-radius:2px}.radio-toggle>li:last-child>label{border-top-right-radius:2px;border-bottom-right-radius:2px}.radio-toggle>li+li>label{border-left:none}.radio-toggle>li>label{display:inline-block;padding:0 12px;margin:0;border:1px solid #236a97;color:#236a97;height:22px;line-height:22px;cursor:pointer;font-weight:600}.radio-toggle input[type=radio]{display:none}.radio-toggle input[type=radio]:checked+label{background-color:#236a97;color:#fff}.radio-toggle input[type=radio]:disabled+label{color:#bbb;border-color:#ddd;background:#ebebeb;cursor:not-allowed}",""]),e.exports=t},418:function(e,t){e.exports=function(e,t,n,r){for(var a=e.length,l=n+(r?1:-1);r?l--:++l<a;)if(t(e[l],l,e))return l;return-1}},509:function(e,t,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var a in t=arguments[n])Object.prototype.hasOwnProperty.call(t,a)&&(e[a]=t[a]);return e}).apply(this,arguments)},a=this&&this.__rest||function(e,t){var n={};for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&t.indexOf(r)<0&&(n[r]=e[r]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var a=0;for(r=Object.getOwnPropertySymbols(e);a<r.length;a++)t.indexOf(r[a])<0&&Object.prototype.propertyIsEnumerable.call(e,r[a])&&(n[r[a]]=e[r[a]])}return n};Object.defineProperty(t,"__esModule",{value:!0});var l=n(2),i=n(315);t.default=function(e){var t=e.fill,n=void 0===t?"currentColor":t,s=a(e,["fill"]);return l.createElement(i.default,r({},s),l.createElement("path",{d:"M14.92 4.804q0 0.357-0.25 0.607l-7.679 7.679q-0.25 0.25-0.607 0.25t-0.607-0.25l-4.446-4.446q-0.25-0.25-0.25-0.607t0.25-0.607l1.214-1.214q0.25-0.25 0.607-0.25t0.607 0.25l2.625 2.634 5.857-5.866q0.25-0.25 0.607-0.25t0.607 0.25l1.214 1.214q0.25 0.25 0.25 0.607z",style:{fill:n}}))}},549:function(e,t,n){"use strict";n.d(t,"a",(function(){return l})),n.d(t,"b",(function(){return i})),n.d(t,"c",(function(){return s}));var r=n(9),a=n(326);function l(e){return Object(r.getJSON)("/api/navigation/component",e).catch(a.a)}function i(){return Object(r.getJSON)("/api/navigation/marketplace").catch(a.a)}function s(){return Object(r.getJSON)("/api/navigation/settings").catch(a.a)}},577:function(e,t,n){"use strict";var r;function a(e){return void 0!==e.release}function l(e){return function(e){return void 0!==e.version}(e)&&void 0!==e.updatedAt}n.d(t,"a",(function(){return r})),n.d(t,"b",(function(){return a})),n.d(t,"c",(function(){return l})),function(e){e.Bundled="BUNDLED",e.External="EXTERNAL"}(r||(r={}))},608:function(e,t,n){"use strict";n.d(t,"b",(function(){return d})),n.d(t,"e",(function(){return m})),n.d(t,"c",(function(){return v})),n.d(t,"d",(function(){return E})),n.d(t,"f",(function(){return y})),n.d(t,"g",(function(){return O})),n.d(t,"h",(function(){return k})),n.d(t,"i",(function(){return j})),n.d(t,"a",(function(){return x}));var r=n(609),a=n.n(r),l=n(9),i=n(387),s=n(326),o=n(577);function c(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function u(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?c(Object(n),!0).forEach((function(t){p(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):c(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function p(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function d(){return Object(l.getJSON)("/api/plugins/available").catch(s.a)}function m(){return Object(l.getJSON)("/api/plugins/pending").catch(s.a)}function g(e){if(!e)return[];return["COMPATIBLE","REQUIRES_SYSTEM_UPGRADE","DEPS_REQUIRE_SYSTEM_UPGRADE"].map(t=>{const n=a()(e,e=>e.status===t);return n>-1?e[n]:void 0}).filter(i.isDefined)}function h(e,t){if(!t)return e;const n=t.indexOf(e);return u({},e,{previousUpdates:n>0?t.slice(0,n):[]})}function b(e=o.a.External){return Object(l.getJSON)("/api/plugins/installed",{f:"category",type:e})}function f(){return Object(l.getJSON)("/api/plugins/updates")}function v(e=o.a.External){return b(e).then(({plugins:e})=>e,s.a)}function E(){return Promise.all([b(),f()]).then(([e,t])=>e.plugins.map(e=>{const n=t.plugins.find(t=>t.key===e.key);return n?u({},n,{},e,{updates:g(n.updates).map(e=>h(e,n.updates))}):e})).catch(s.a)}function y(){return Promise.all([f(),b()]).then(([e,t])=>e.plugins.map(e=>{const n=g(e.updates).map(t=>h(t,e.updates)),r=t.plugins.find(t=>t.key===e.key);return r?u({},r,{},e,{updates:n}):u({},e,{updates:n})})).catch(s.a)}function O(e){return Object(l.post)("/api/plugins/install",e).catch(s.a)}function k(e){return Object(l.post)("/api/plugins/uninstall",e).catch(s.a)}function j(e){return Object(l.post)("/api/plugins/update",e).catch(s.a)}function x(){return Object(l.post)("/api/plugins/cancel_all").catch(s.a)}},609:function(e,t,n){var r=n(418),a=n(334),l=n(382),i=Math.max,s=Math.min;e.exports=function(e,t,n){var o=null==e?0:e.length;if(!o)return-1;var c=o-1;return void 0!==n&&(c=l(n),c=n<0?i(o+c,0):s(c,o-1)),r(e,a(t,3),c,!0)}},712:function(e,t,n){"use strict";n.d(t,"b",(function(){return a})),n.d(t,"c",(function(){return l}));var r=n(2);const a={installing:[],removing:[],updating:[]},l="UP",i=r.createContext({fetchSystemStatus:()=>{},fetchPendingPlugins:()=>{},pendingPlugins:a,systemStatus:l});t.a=i}}]);
//# sourceMappingURL=293.m.390e4a6e.chunk.js.map