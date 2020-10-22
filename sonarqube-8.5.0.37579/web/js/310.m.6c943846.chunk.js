(window.webpackJsonp=window.webpackJsonp||[]).push([[310],{1423:function(e,t,a){var n=a(313),s=a(1424);"string"==typeof(s=s.__esModule?s.default:s)&&(s=[[e.i,s,""]]);var r={insert:"head",singleton:!1},o=(n(s,r),s.locals?s.locals:{});e.exports=o},1424:function(e,t,a){(t=a(314)(!1)).push([e.i,".bt-search-form{display:flex;align-items:flex-end}.bt-search-form>li+li{margin-left:16px}.bt-search-form-label{margin-bottom:4px}.bt-search-form-field{padding:4px 0}.bt-search-form-large{flex:1}.bt-workers-warning-icon{margin-top:5px}.emphasised-measure{font-size:24px;font-weight:300}",""]),e.exports=t},1836:function(e,t,a){"use strict";a.r(t),a.d(t,"BackgroundTasksApp",(function(){return Ye}));var n=a(412),s=a.n(n),r=a(373),o=a.n(r),l=a(2),c=a(332),i=a(323),u=a(26),d=a(31),m=a(471),p=a(573),h=a(335),g=a(469),b=a(548),k=(a(1423),a(574));function E(e,t){return"".concat(e).concat(t)}function f({tasks:e}){return e.length<1e3?null:l.createElement("footer",{className:"spacer-top note text-center"},Object(d.translateWithParameters)("max_results_reached",1e3))}var C=a(316),y=a(312),O=a(324),N=a.n(O),x=a(318),S=a.n(x),v=a(672),_=a.n(v);function j(){return l.createElement(l.Fragment,null,l.createElement("p",{className:"spacer-bottom"},l.createElement("strong",null,Object(d.translate)("background_tasks.add_more_workers"))),l.createElement("p",{className:"big-spacer-bottom markdown"},Object(d.translate)("background_tasks.add_more_workers.text")),l.createElement("p",null,l.createElement("a",{href:"https://redirect.sonarsource.com/editions/enterprise.html",rel:"noopener noreferrer",target:"_blank"},Object(d.translate)("learn_more"))))}var D=a(330),w=a.n(D),P=a(345),A=a.n(P),T=a(322);class L extends l.PureComponent{constructor(e){super(e),this.mounted=!1,this.handleClose=()=>{this.props.onClose()},this.handleWorkerCountChange=e=>this.setState({newWorkerCount:e.value}),this.handleSubmit=e=>{e.preventDefault(),this.setState({submitting:!0});const{newWorkerCount:t}=this.state;Object(p.l)(t).then(()=>{this.mounted&&this.props.onClose(t)},()=>{this.mounted&&this.setState({submitting:!1})})},this.state={newWorkerCount:e.workerCount,submitting:!1}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const e=[];for(let t=1;t<=10;t++)e.push({label:String(t),value:t});return l.createElement(w.a,{contentLabel:Object(d.translate)("background_tasks.change_number_of_workers"),onRequestClose:this.handleClose},l.createElement("header",{className:"modal-head"},l.createElement("h2",null,Object(d.translate)("background_tasks.change_number_of_workers"))),l.createElement("form",{onSubmit:this.handleSubmit},l.createElement("div",{className:"modal-body"},l.createElement(A.a,{className:"input-tiny spacer-top",clearable:!1,onChange:this.handleWorkerCountChange,options:e,searchable:!1,value:this.state.newWorkerCount}),l.createElement(T.Alert,{className:"big-spacer-top",variant:"info"},Object(d.translate)("background_tasks.change_number_of_workers.hint"))),l.createElement("footer",{className:"modal-foot"},l.createElement("div",null,this.state.submitting&&l.createElement("i",{className:"spinner spacer-right"}),l.createElement(y.SubmitButton,{disabled:this.state.submitting},Object(d.translate)("save")),l.createElement(y.ResetButtonLink,{onClick:this.handleClose},Object(d.translate)("cancel"))))))}}class M extends l.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={canSetWorkerCount:!1,formOpen:!1,loading:!0,noSupportPopup:!1,workerCount:1},this.loadWorkers=()=>{this.setState({loading:!0}),Object(p.k)().then(({canSetWorkerCount:e,value:t})=>{this.mounted&&this.setState({canSetWorkerCount:e,loading:!1,workerCount:t})},()=>{this.mounted&&this.setState({loading:!1})})},this.closeForm=e=>e?this.setState({formOpen:!1,workerCount:e}):this.setState({formOpen:!1}),this.handleChangeClick=()=>{this.setState({formOpen:!0})},this.handleHelpClick=e=>{e.preventDefault(),e.stopPropagation(),this.toggleNoSupportPopup()},this.toggleNoSupportPopup=e=>{void 0!==e?this.setState({noSupportPopup:e}):this.setState(e=>({noSupportPopup:!e.noSupportPopup}))}}componentDidMount(){this.mounted=!0,this.loadWorkers()}componentWillUnmount(){this.mounted=!1}render(){const{canSetWorkerCount:e,formOpen:t,loading:a,workerCount:n}=this.state;return l.createElement("div",{className:"display-flex-center"},!a&&n>1&&l.createElement(S.a,{overlay:Object(d.translate)("background_tasks.number_of_workers.warning")},l.createElement("span",{className:"display-inline-flex-center little-spacer-right"},l.createElement(_.a,{fill:"#d3d3d3"}))),l.createElement("span",{className:"text-middle"},Object(d.translate)("background_tasks.number_of_workers"),a?l.createElement("i",{className:"spinner little-spacer-left"}):l.createElement("strong",{className:"little-spacer-left"},n)),!a&&e&&l.createElement(S.a,{overlay:Object(d.translate)("background_tasks.change_number_of_workers")},l.createElement(y.EditButton,{className:"js-edit button-small spacer-left",onClick:this.handleChangeClick})),!a&&!e&&l.createElement(N.a,{className:"spacer-left",overlay:l.createElement(j,null)}),t&&l.createElement(L,{onClose:this.closeForm,workerCount:this.state.workerCount}))}}function F(e){return l.createElement("header",{className:"page-header"},l.createElement("h1",{className:"page-title"},Object(d.translate)("background_tasks.page")),!e.component&&l.createElement("div",{className:"page-actions"},l.createElement(M,null)),l.createElement("p",{className:"page-description"},Object(d.translate)("background_tasks.page.description"),l.createElement(C.Link,{className:"spacer-left",target:"_blank",to:{pathname:"/documentation/analysis/background-tasks/"}},Object(d.translate)("learn_more"))))}var R=a(350),q=a.n(R),I=a(341),W=a.n(I);class U extends l.PureComponent{constructor(){super(...arguments),this.handleChange=e=>{const t=e?k.b.ONLY_CURRENTS:k.b.ALL;this.props.onChange(t)}}render(){const e=this.props.value===k.b.ONLY_CURRENTS;return l.createElement("div",{className:"bt-search-form-field"},l.createElement(W.a,{checked:e,onCheck:this.handleChange},l.createElement("span",{className:"little-spacer-left"},Object(d.translate)("yes"))))}}var z=a(611);class B extends l.PureComponent{constructor(){super(...arguments),this.handleDateRangeChange=({from:e,to:t})=>{this.props.onChange({minSubmittedAt:e,maxExecutedAt:t})}}render(){const e={from:this.props.minSubmittedAt,to:this.props.maxExecutedAt};return l.createElement("div",{className:"nowrap"},l.createElement(z.a,{onChange:this.handleDateRangeChange,value:e}))}}class Y extends l.PureComponent{constructor(){super(...arguments),this.handleChange=({value:e})=>{this.props.onChange(e)}}render(){const e=[{value:k.e.ALL,label:Object(d.translate)("background_task.status.ALL")},{value:k.e.ALL_EXCEPT_PENDING,label:Object(d.translate)("background_task.status.ALL_EXCEPT_PENDING")},{value:b.a.Pending,label:Object(d.translate)("background_task.status.PENDING")},{value:b.a.InProgress,label:Object(d.translate)("background_task.status.IN_PROGRESS")},{value:b.a.Success,label:Object(d.translate)("background_task.status.SUCCESS")},{value:b.a.Failed,label:Object(d.translate)("background_task.status.FAILED")},{value:b.a.Canceled,label:Object(d.translate)("background_task.status.CANCELED")}];return l.createElement(A.a,{className:"input-medium",clearable:!1,onChange:this.handleChange,options:e,searchable:!1,value:this.props.value})}}class G extends l.PureComponent{constructor(){super(...arguments),this.handleChange=({value:e})=>{this.props.onChange(e)}}render(){const{value:e,types:t}=this.props,a=t.map(e=>({value:e,label:Object(d.translate)("background_task.type",e)})),n=[{value:k.a,label:Object(d.translate)("background_task.type.ALL")},...a];return l.createElement(A.a,{className:"input-medium",clearable:!1,onChange:this.handleChange,options:n,searchable:!1,value:e})}}class K extends l.PureComponent{constructor(){super(...arguments),this.handleStatusChange=e=>{this.props.onFilterUpdate({status:e})},this.handleTypeChange=e=>{this.props.onFilterUpdate({taskType:e})},this.handleCurrentsChange=e=>{this.props.onFilterUpdate({currents:e})},this.handleDateChange=e=>{this.props.onFilterUpdate(e)},this.handleQueryChange=e=>{this.props.onFilterUpdate({query:e})},this.handleReset=()=>{this.props.onFilterUpdate(k.d)}}renderSearchBox(){const{component:e,query:t}=this.props;return e?null:l.createElement("li",{className:"bt-search-form-large"},l.createElement(q.a,{onChange:this.handleQueryChange,placeholder:Object(d.translate)("background_tasks.search_by_task_or_component"),value:t}))}render(){const{loading:e,component:t,types:a,status:n,taskType:s,currents:r,minSubmittedAt:o,maxExecutedAt:c}=this.props;return l.createElement("section",{className:"big-spacer-top big-spacer-bottom"},l.createElement("ul",{className:"bt-search-form"},l.createElement("li",null,l.createElement("h6",{className:"bt-search-form-label"},Object(d.translate)("status")),l.createElement(Y,{onChange:this.handleStatusChange,value:n})),a.length>1&&l.createElement("li",null,l.createElement("h6",{className:"bt-search-form-label"},Object(d.translate)("type")),l.createElement(G,{onChange:this.handleTypeChange,types:a,value:s})),!t&&l.createElement("li",null,l.createElement("h6",{className:"bt-search-form-label"},Object(d.translate)("background_tasks.currents_filter.ONLY_CURRENTS")),l.createElement(U,{onChange:this.handleCurrentsChange,value:r})),l.createElement("li",null,l.createElement("h6",{className:"bt-search-form-label"},Object(d.translate)("date")),l.createElement(B,{maxExecutedAt:c,minSubmittedAt:o,onChange:this.handleDateChange})),this.renderSearchBox(),l.createElement("li",{className:"nowrap"},l.createElement(y.Button,{className:"js-reload",disabled:e,onClick:this.props.onReload},Object(d.translate)("reload"))," ",l.createElement(y.Button,{disabled:e,onClick:this.handleReset},Object(d.translate)("reset_verb")))))}}var X=a(380),H=a.n(X),Q=a(342),V=a(325);var J=Object(i.connect)(e=>({isSystemAdmin:Object(V.getAppState)(e).canAdmin}))((function({isSystemAdmin:e,onCancelAllPending:t,pendingCount:a}){return void 0===a?null:l.createElement("span",null,l.createElement("span",{className:"emphasised-measure"},a),l.createElement("span",{className:"little-spacer-left display-inline-flex-center"},Object(d.translate)("background_tasks.pending"),e&&a>0&&l.createElement(H.a,{cancelButtonText:Object(d.translate)("close"),confirmButtonText:Object(d.translate)("background_tasks.cancel_all_tasks.submit"),isDestructive:!0,modalBody:Object(d.translate)("background_tasks.cancel_all_tasks.text"),modalHeader:Object(d.translate)("background_tasks.cancel_all_tasks"),onConfirm:t},({onClick:e})=>l.createElement(S.a,{overlay:Object(d.translate)("background_tasks.cancel_all_tasks")},l.createElement(y.ClearButton,{className:"little-spacer-left",color:Q.colors.red,onClick:e})))))})),Z=a(320);function $({className:e,pendingCount:t,pendingTime:a}){return!a||!t||a<1e3?null:l.createElement("span",{className:e},l.createElement("span",{className:"emphasised-measure"},Object(Z.formatMeasure)(a,"MILLISEC")),l.createElement("span",{className:"little-spacer-left"},Object(d.translate)("background_tasks.pending_time")),l.createElement(N.a,{className:"little-spacer-left",overlay:Object(d.translate)("background_tasks.pending_time.description")}))}function ee({className:e,failingCount:t,onShowFailing:a}){return void 0===t?null:l.createElement("span",{className:e},t>0?l.createElement(y.ButtonLink,{className:"emphasised-measure text-baseline",onClick:a},t):l.createElement("span",{className:"emphasised-measure"},t),l.createElement("span",{className:"little-spacer-left"},Object(d.translate)("background_tasks.failures")),l.createElement(N.a,{className:"little-spacer-left",overlay:Object(d.translate)("background_tasks.failing_count")}))}function te(e,t){if(null==e)return{};var a,n,s=function(e,t){if(null==e)return{};var a,n,s={},r=Object.keys(e);for(n=0;n<r.length;n++)a=r[n],t.indexOf(a)>=0||(s[a]=e[a]);return s}(e,t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(n=0;n<r.length;n++)a=r[n],t.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(e,a)&&(s[a]=e[a])}return s}function ae(e){let{component:t,pendingCount:a,pendingTime:n}=e,s=te(e,["component","pendingCount","pendingTime"]);return l.createElement("section",{className:"big-spacer-top big-spacer-bottom"},l.createElement(J,{onCancelAllPending:s.onCancelAllPending,pendingCount:a}),!t&&l.createElement($,{className:"huge-spacer-left",pendingCount:a,pendingTime:n}),!t&&l.createElement(ee,{className:"huge-spacer-left",failingCount:s.failingCount,onShowFailing:s.onShowFailing}))}var ne=a(311),se=a(383),re=a.n(se),oe=a(349),le=a.n(oe),ce=a(331);class ie extends l.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={},this.handleCloseClick=e=>{e.preventDefault(),this.props.onClose()}}componentDidMount(){this.mounted=!0,this.loadScannerContext()}componentWillUnmount(){this.mounted=!1}loadScannerContext(){Object(p.h)(this.props.task.id,["scannerContext"]).then(e=>{this.mounted&&this.setState({scannerContext:e.scannerContext})})}render(){const{task:e}=this.props,{scannerContext:t}=this.state;return l.createElement(w.a,{contentLabel:"scanner context",onRequestClose:this.props.onClose,size:"large"},l.createElement("div",{className:"modal-head"},l.createElement("h2",null,Object(d.translate)("background_tasks.scanner_context"),": ",e.componentName," [",Object(d.translate)("background_task.type",e.type),"]")),l.createElement("div",{className:"modal-body modal-container"},null!=t?l.createElement("pre",{className:"js-task-scanner-context"},t):l.createElement("i",{className:"spinner"})),l.createElement("div",{className:"modal-foot"},l.createElement("a",{className:"js-modal-close",href:"#",onClick:this.handleCloseClick},Object(d.translate)("close"))))}}class ue extends l.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!0},this.handleCloseClick=e=>{e.preventDefault(),this.props.onClose()}}componentDidMount(){this.mounted=!0,this.loadStacktrace()}componentWillUnmount(){this.mounted=!1}loadStacktrace(){Object(p.h)(this.props.task.id,["stacktrace"]).then(e=>{this.mounted&&this.setState({loading:!1,stacktrace:e.errorStacktrace})},()=>{this.mounted&&this.setState({loading:!1})})}render(){const{task:e}=this.props,{loading:t,stacktrace:a}=this.state;return l.createElement(w.a,{contentLabel:"stacktrace",onRequestClose:this.props.onClose,size:"large"},l.createElement("div",{className:"modal-head"},l.createElement("h2",null,Object(d.translate)("background_tasks.error_stacktrace"),": ",e.componentName," [",Object(d.translate)("background_task.type",e.type),"]")),l.createElement("div",{className:"modal-body modal-container"},t?l.createElement("i",{className:"spinner"}):a?l.createElement("div",null,l.createElement("h4",{className:"spacer-bottom"},Object(d.translate)("background_tasks.error_stacktrace")),l.createElement("pre",{className:"js-task-stacktrace"},a)):l.createElement("div",null,l.createElement("h4",{className:"spacer-bottom"},Object(d.translate)("background_tasks.error_message")),l.createElement("pre",{className:"js-task-error-message"},e.errorMessage))),l.createElement("div",{className:"modal-foot"},l.createElement("a",{className:"js-modal-close",href:"#",onClick:this.handleCloseClick},Object(d.translate)("close"))))}}const de=Object(ce.lazyLoadComponent)(()=>a.e(16).then(a.bind(null,1829)),"AnalysisWarningsModal");class me extends l.PureComponent{constructor(){super(...arguments),this.state={cancelTaskOpen:!1,scannerContextOpen:!1,stacktraceOpen:!1,warningsOpen:!1},this.handleFilterClick=()=>{this.props.onFilterTask(this.props.task)},this.handleCancelTask=()=>this.props.onCancelTask(this.props.task),this.handleCancelClick=()=>{this.setState({cancelTaskOpen:!0})},this.handleShowScannerContextClick=()=>{this.setState({scannerContextOpen:!0})},this.closeCancelTask=()=>{this.setState({cancelTaskOpen:!1})},this.closeScannerContext=()=>{this.setState({scannerContextOpen:!1})},this.handleShowStacktraceClick=()=>{this.setState({stacktraceOpen:!0})},this.closeStacktrace=()=>{this.setState({stacktraceOpen:!1})},this.handleShowWarningsClick=()=>{this.setState({warningsOpen:!0})},this.closeWarnings=()=>{this.setState({warningsOpen:!1})}}render(){const{component:e,task:t}=this.props,a=void 0===e,n=t.status===b.a.Pending,s=void 0!==t.errorMessage,r=void 0!==t.warningCount&&t.warningCount>0;return a||n||t.hasScannerContext||s||r?l.createElement("td",{className:"thin nowrap"},l.createElement(re.a,{className:"js-task-action"},a&&t.componentName&&l.createElement(se.ActionsDropdownItem,{className:"js-task-filter",onClick:this.handleFilterClick},Object(d.translateWithParameters)("background_tasks.filter_by_component_x",t.componentName)),n&&l.createElement(se.ActionsDropdownItem,{className:"js-task-cancel",destructive:!0,onClick:this.handleCancelClick},Object(d.translate)("background_tasks.cancel_task")),t.hasScannerContext&&l.createElement(se.ActionsDropdownItem,{className:"js-task-show-scanner-context",onClick:this.handleShowScannerContextClick},Object(d.translate)("background_tasks.show_scanner_context")),s&&l.createElement(se.ActionsDropdownItem,{className:"js-task-show-stacktrace",onClick:this.handleShowStacktraceClick},Object(d.translate)("background_tasks.show_stacktrace")),r&&l.createElement(se.ActionsDropdownItem,{className:"js-task-show-warnings",onClick:this.handleShowWarningsClick},Object(d.translate)("background_tasks.show_warnings"))),this.state.cancelTaskOpen&&l.createElement(le.a,{cancelButtonText:Object(d.translate)("close"),confirmButtonText:Object(d.translate)("background_tasks.cancel_task"),header:Object(d.translate)("background_tasks.cancel_task"),isDestructive:!0,onClose:this.closeCancelTask,onConfirm:this.handleCancelTask},Object(d.translate)("background_tasks.cancel_task.text")),this.state.scannerContextOpen&&l.createElement(ie,{onClose:this.closeScannerContext,task:t}),this.state.stacktraceOpen&&l.createElement(ue,{onClose:this.closeStacktrace,task:t}),this.state.warningsOpen&&l.createElement(de,{componentKey:t.componentKey,onClose:this.closeWarnings,taskId:t.id})):l.createElement("td",null," ")}}var pe=a(405),he=a.n(pe),ge=a(535),be=a.n(ge),ke=a(344),Ee=a.n(ke),fe=a(772),Ce=a(321),ye=a(337);function Oe({type:e}){return l.createElement("span",{className:"display-inline-block note"},"[",Object(d.translate)("background_task.type",e),"]")}function Ne({task:e}){return e.componentKey?l.createElement("td",null,void 0!==e.branch&&l.createElement(he.a,{className:"little-spacer-right"}),void 0!==e.pullRequest&&l.createElement(be.a,{className:"little-spacer-right"}),!e.branch&&!e.pullRequest&&e.componentQualifier&&l.createElement("span",{className:"little-spacer-right"},l.createElement(Ee.a,{qualifier:e.componentQualifier})),e.organization&&l.createElement(fe.a,{organizationKey:e.organization}),e.componentName&&l.createElement(C.Link,{className:"spacer-right",to:xe(e.componentKey,e)},e.componentName,e.branch&&l.createElement("span",{className:"text-limited text-text-top",title:e.branch},l.createElement("span",{style:{marginLeft:5,marginRight:5}},"/"),e.branch),e.pullRequest&&l.createElement("span",{className:"text-limited text-text-top",title:e.pullRequestTitle},l.createElement("span",{style:{marginLeft:5,marginRight:5}},"/"),e.pullRequest)),l.createElement(Oe,{type:e.type})):l.createElement("td",null,l.createElement("span",{className:"note"},e.id),l.createElement(Oe,{type:e.type}))}function xe(e,t){return Object(ye.c)(t.componentQualifier)?Object(Ce.s)(e):t.branch?Object(Ce.c)(e,t.branch):t.pullRequest?Object(Ce.v)(e,t.pullRequest):Object(Ce.u)(e)}var Se=a(681),ve=a(556),_e=a.n(ve);function je({date:e,baseDate:t}){const a=e&&Object(u.parseDate)(e),n=t&&Object(u.parseDate)(t),s=a&&n&&Object(u.isValidDate)(a)&&Object(u.isValidDate)(n)?Se(a,n):0;return l.createElement("td",{className:"thin nowrap text-right"},s>0&&l.createElement("span",{className:"text-warning little-spacer-right"},"(+".concat(s,"d)")),a&&Object(u.isValidDate)(a)?l.createElement(_e.a,{date:a,long:!0}):"")}var De=a(768),we=a(351),Pe=a.n(we);function Ae({submittedAt:e,prevSubmittedAt:t}){const a=!t||!De(Object(u.parseDate)(e),Object(u.parseDate)(t));return l.createElement("td",{className:"thin nowrap text-right small"},a?l.createElement(Pe.a,{date:e,long:!0}):"")}function Te({ms:e}){return l.createElement("td",{className:"thin nowrap text-right"},e&&function(e){if(!e)return"";if(e<1e3)return E(e,"ms");if(e<1e4){const t=Math.floor(e/1e3);return t+"."+E(e-1e3*t,"s")}if(e<6e4){return E(Math.floor(e/1e3),"s")}if(e<6e5){const t=Math.floor(e/6e4),a=Math.floor((e-6e4*t)/1e3);return E(t,"min")+" "+E(a,"s")}const t=Math.floor(e/36e5),a=Math.floor((e-36e5*t)/6e4);return E(t,"h")+" "+E(a,"min")}(e))}function Le({id:e}){return l.createElement("td",{className:"thin nowrap"},l.createElement("div",{className:"note"},e))}var Me=a(1425),Fe=a.n(Me);function Re({status:e}){let t;switch(e){case b.a.Pending:t=l.createElement(Fe.a,null);break;case b.a.InProgress:t=l.createElement("i",{className:"spinner"});break;case b.a.Success:t=l.createElement("span",{className:"badge badge-success"},Object(d.translate)("background_task.status.SUCCESS"));break;case b.a.Failed:t=l.createElement("span",{className:"badge badge-error"},Object(d.translate)("background_task.status.FAILED"));break;case b.a.Canceled:t=l.createElement("span",{className:"badge"},Object(d.translate)("background_task.status.CANCELED"));break;default:t=""}return l.createElement("td",{className:"thin spacer-right"},t)}function qe({submitter:e}){return l.createElement("td",{className:"thin note"},l.createElement("span",{className:"text-limited-small text-bottom"},e||Object(d.translate)("anonymous")))}function Ie(e){const{task:t,component:a,onCancelTask:n,onFilterTask:s,previousTask:r}=e;return l.createElement("tr",null,l.createElement(Re,{status:t.status}),l.createElement(Ne,{task:t}),l.createElement(Le,{id:t.id}),l.createElement(qe,{submitter:t.submitterLogin}),l.createElement(Ae,{prevSubmittedAt:r&&r.submittedAt,submittedAt:t.submittedAt}),l.createElement(je,{date:t.submittedAt}),l.createElement(je,{baseDate:t.submittedAt,date:t.startedAt}),l.createElement(je,{baseDate:t.submittedAt,date:t.executedAt}),l.createElement(Te,{ms:t.executionTimeMs}),l.createElement(me,{component:a,onCancelTask:n,onFilterTask:s,task:t}))}function We({tasks:e,component:t,loading:a,onCancelTask:n,onFilterTask:s}){const r=ne("data zebra zebra-hover background-tasks",{"new-loading":a});return l.createElement("div",{className:"boxed-group boxed-group-inner"},l.createElement("table",{className:r},l.createElement("thead",null,l.createElement("tr",null,l.createElement("th",null,Object(d.translate)("background_tasks.table.status")),l.createElement("th",null,Object(d.translate)("background_tasks.table.task")),l.createElement("th",null,Object(d.translate)("background_tasks.table.id")),l.createElement("th",null,Object(d.translate)("background_tasks.table.submitter")),l.createElement("th",null," "),l.createElement("th",{className:"text-right"},Object(d.translate)("background_tasks.table.submitted")),l.createElement("th",{className:"text-right"},Object(d.translate)("background_tasks.table.started")),l.createElement("th",{className:"text-right"},Object(d.translate)("background_tasks.table.finished")),l.createElement("th",{className:"text-right"},Object(d.translate)("background_tasks.table.duration")),l.createElement("th",null," "))),l.createElement("tbody",null,e.map((e,a,r)=>l.createElement(Ie,{component:t,key:e.id,onCancelTask:n,onFilterTask:s,previousTask:a>0?r[a-1]:void 0,task:e})))))}function Ue(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,n)}return a}function ze(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?Ue(Object(a),!0).forEach((function(t){Be(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):Ue(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}function Be(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}class Ye extends l.PureComponent{constructor(e){super(e),this.mounted=!1,this.stopLoading=()=>{this.mounted&&this.setState({loading:!1})},this.loadTasks=()=>{this.setState({loading:!0});const e=function(e={}){const t={};return e.status===k.e.ALL?t.status=[b.a.Pending,b.a.InProgress,b.a.Success,b.a.Failed,b.a.Canceled].join():e.status===k.e.ALL_EXCEPT_PENDING?t.status=[b.a.InProgress,b.a.Success,b.a.Failed,b.a.Canceled].join():t.status=e.status,e.taskType!==k.a&&(t.type=e.taskType),e.currents!==k.b.ALL&&(t.onlyCurrents=!0),e.minSubmittedAt&&(t.minSubmittedAt=Object(u.toShortNotSoISOString)(e.minSubmittedAt)),e.maxExecutedAt&&(t.maxExecutedAt=Object(u.toShortNotSoISOString)(e.maxExecutedAt)),e.query&&(t.q=e.query),t}({status:this.props.location.query.status||k.d.status,taskType:this.props.location.query.taskType||k.d.taskType,currents:this.props.location.query.currents||k.d.currents,minSubmittedAt:this.props.location.query.minSubmittedAt||k.d.minSubmittedAt,maxExecutedAt:this.props.location.query.maxExecutedAt||k.d.maxExecutedAt,query:this.props.location.query.query||k.d.query});this.props.component&&(e.componentId=this.props.component.id),Promise.all([Object(p.d)(e),Object(p.g)(e.componentId)]).then(([{tasks:e},t])=>{if(this.mounted){const a=s()(e.map(e=>e.organization).filter(e=>e));this.props.fetchOrganizations(a),this.setState({failingCount:t.failing,loading:!1,pendingCount:t.pending,pendingTime:t.pendingTime,tasks:e})}},this.stopLoading)},this.handleFilterUpdate=e=>{const t=ze({},this.props.location.query,{},e);Object.keys(k.d).forEach(e=>{t[e]===k.d[e]&&delete t[e]}),t.minSubmittedAt&&(t.minSubmittedAt=Object(u.toShortNotSoISOString)(t.minSubmittedAt)),t.maxExecutedAt&&(t.maxExecutedAt=Object(u.toShortNotSoISOString)(t.maxExecutedAt)),this.props.router.push({pathname:this.props.location.pathname,query:t})},this.handleCancelTask=e=>(this.setState({loading:!0}),Object(p.b)(e.id).then(e=>{this.mounted&&this.setState(t=>{return{tasks:(a=t.tasks,n=e,a.map(e=>e.id===n.id?n:e)),loading:!1};var a,n})},this.stopLoading)),this.handleFilterTask=e=>{this.handleFilterUpdate({query:e.componentKey})},this.handleShowFailing=()=>{this.handleFilterUpdate(ze({},k.d,{status:b.a.Failed,currents:k.b.ONLY_CURRENTS}))},this.handleCancelAllPending=()=>{this.setState({loading:!0}),Object(p.a)().then(()=>{this.mounted&&this.loadTasks()},this.stopLoading)},this.state={failingCount:0,loading:!0,pendingCount:0,tasks:[]},this.loadTasksDebounced=o()(this.loadTasks,k.c)}componentDidMount(){this.mounted=!0,Object(p.j)().then(e=>{this.setState({types:e}),this.loadTasks()},()=>{})}componentDidUpdate(e){e.component===this.props.component&&e.location===this.props.location||this.loadTasksDebounced()}componentWillUnmount(){this.mounted=!1}render(){const{component:e}=this.props,{loading:t,types:a,tasks:n}=this.state;if(!a)return l.createElement("div",{className:"page page-limited"},l.createElement("i",{className:"spinner"}));const s=this.props.location.query.status||k.d.status,r=this.props.location.query.taskType||k.d.taskType,o=this.props.location.query.currents||k.d.currents,i=Object(m.parseAsDate)(this.props.location.query.minSubmittedAt),u=Object(m.parseAsDate)(this.props.location.query.maxExecutedAt),p=this.props.location.query.query||"";return l.createElement("div",{className:"page page-limited"},l.createElement(h.a,{suggestions:"background_tasks"}),l.createElement(c.a,{defer:!1,title:Object(d.translate)("background_tasks.page")}),l.createElement(F,{component:e}),l.createElement(ae,{component:e,failingCount:this.state.failingCount,onCancelAllPending:this.handleCancelAllPending,onShowFailing:this.handleShowFailing,pendingCount:this.state.pendingCount,pendingTime:this.state.pendingTime}),l.createElement(K,{component:e,currents:o,loading:t,maxExecutedAt:u,minSubmittedAt:i,onFilterUpdate:this.handleFilterUpdate,onReload:this.loadTasksDebounced,query:p,status:s,taskType:r,types:a}),l.createElement(We,{component:e,loading:t,onCancelTask:this.handleCancelTask,onFilterTask:this.handleFilterTask,tasks:n}),l.createElement(f,{tasks:n}))}}const Ge={fetchOrganizations:g.g};t.default=Object(i.connect)(null,Ge)(Ye)},335:function(e,t,a){"use strict";a.d(t,"a",(function(){return r}));var n=a(2),s=a(368);function r({suggestions:e}){return n.createElement(s.a.Consumer,null,({addSuggestions:t,removeSuggestions:a})=>n.createElement(o,{addSuggestions:t,removeSuggestions:a,suggestions:e}))}class o extends n.PureComponent{componentDidMount(){this.props.addSuggestions(this.props.suggestions)}componentDidUpdate(e){e.suggestions!==this.props.suggestions&&(this.props.removeSuggestions(this.props.suggestions),this.props.addSuggestions(e.suggestions))}componentWillUnmount(){this.props.removeSuggestions(this.props.suggestions)}render(){return null}}},518:function(e,t,a){"use strict";a.d(t,"a",(function(){return _}));var n=a(478),s=a.n(n),r=a(311),o=a(415),l=a(500),c=a(514),i=a(515),u=a(2),d=a(319),m=a(312),p=a(533),h=a.n(p),g=a(345),b=a.n(g),k=a(519),E=a.n(k),f=a(483),C=a.n(f),y=a(413),O=a.n(y),N=a(331),x=a(31);a(520),a(522);function S(e,t){if(null==e)return{};var a,n,s=function(e,t){if(null==e)return{};var a,n,s={},r=Object.keys(e);for(n=0;n<r.length;n++)a=r[n],t.indexOf(a)>=0||(s[a]=e[a]);return s}(e,t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(n=0;n<r.length;n++)a=r[n],t.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(e,a)&&(s[a]=e[a])}return s}const v=Object(N.lazyLoadComponent)(()=>a.e(304).then(a.t.bind(null,668,7)),"DayPicker");class _ extends u.PureComponent{constructor(e){super(e),this.focus=()=>{this.input&&this.input.focus(),this.openCalendar()},this.handleResetClick=()=>{this.closeCalendar(),this.props.onChange(void 0)},this.openCalendar=()=>{this.setState({currentMonth:this.props.value||this.props.currentMonth||new Date,lastHovered:void 0,open:!0})},this.closeCalendar=()=>{this.setState({open:!1})},this.handleDayClick=(e,t)=>{t.disabled||(this.closeCalendar(),this.props.onChange(e))},this.handleDayMouseEnter=(e,t)=>{this.setState({lastHovered:t.disabled?void 0:e})},this.handleCurrentMonthChange=({value:e})=>{this.setState(t=>({currentMonth:l(t.currentMonth,e)}))},this.handleCurrentYearChange=({value:e})=>{this.setState(t=>({currentMonth:c(t.currentMonth,e)}))},this.handlePreviousMonthClick=()=>{this.setState(e=>({currentMonth:i(e.currentMonth,1)}))},this.handleNextMonthClick=()=>{this.setState(e=>({currentMonth:o(e.currentMonth,1)}))},this.state={currentMonth:e.value||e.currentMonth||new Date,open:!1}}render(){const{highlightFrom:e,highlightTo:t,minDate:a,value:n}=this.props,{lastHovered:o}=this.state,l=this.props.maxDate||new Date,c=s()(12),i=s()((new Date).getFullYear()-10,(new Date).getFullYear()+1),d=n?[n]:[];let p;const g=o||n;e&&g&&(p={highlighted:{from:e,to:g}},d.push(e)),t&&g&&(p={highlighted:{from:g,to:t}},d.push(t));const k=s()(7).map(x.getWeekDayName),f=s()(7).map(x.getShortWeekDayName);return u.createElement(h.a,{onClickOutside:this.closeCalendar},u.createElement("span",{className:r("date-input-control",this.props.className)},u.createElement(D,{className:r("date-input-control-input",this.props.inputClassName,{"is-filled":void 0!==this.props.value}),innerRef:e=>this.input=e,name:this.props.name,onFocus:this.openCalendar,placeholder:this.props.placeholder,readOnly:!0,type:"text",value:n}),u.createElement(E.a,{className:"date-input-control-icon",fill:""}),void 0!==this.props.value&&u.createElement(m.ClearButton,{className:"button-tiny date-input-control-reset",iconProps:{size:12},onClick:this.handleResetClick}),this.state.open&&u.createElement("div",{className:"date-input-calendar"},u.createElement("nav",{className:"date-input-calendar-nav"},u.createElement(m.ButtonIcon,{className:"button-small",onClick:this.handlePreviousMonthClick},u.createElement(C.a,null)),u.createElement("div",{className:"date-input-calender-month"},u.createElement(b.a,{className:"date-input-calender-month-select",onChange:this.handleCurrentMonthChange,options:c.map(e=>({label:Object(x.getShortMonthName)(e),value:e})),value:this.state.currentMonth.getMonth()}),u.createElement(b.a,{className:"date-input-calender-month-select spacer-left",onChange:this.handleCurrentYearChange,options:i.map(e=>({label:String(e),value:e})),value:this.state.currentMonth.getFullYear()})),u.createElement(m.ButtonIcon,{className:"button-small",onClick:this.handleNextMonthClick},u.createElement(O.a,null))),u.createElement(v,{captionElement:u.createElement(j,null),disabledDays:{after:l,before:a},firstDayOfWeek:1,modifiers:p,month:this.state.currentMonth,navbarElement:u.createElement(j,null),onDayClick:this.handleDayClick,onDayMouseEnter:this.handleDayMouseEnter,selectedDays:d,weekdaysLong:k,weekdaysShort:f}))))}}function j(){return null}const D=Object(d.injectIntl)(e=>{let{innerRef:t,intl:a,value:n}=e,s=S(e,["innerRef","intl","value"]);const r=n&&a.formatDate(n,{year:"numeric",month:"short",day:"numeric"});return u.createElement("input",Object.assign({},s,{ref:t,value:r||""}))})},520:function(e,t,a){var n=a(313),s=a(521);"string"==typeof(s=s.__esModule?s.default:s)&&(s=[[e.i,s,""]]);var r={insert:"head",singleton:!1},o=(n(s,r),s.locals?s.locals:{});e.exports=o},521:function(e,t,a){(t=a(314)(!1)).push([e.i,".DayPicker{display:inline-block}.DayPicker-wrapper{position:relative;-webkit-user-select:none;-ms-user-select:none;user-select:none;padding-bottom:8px;flex-direction:row}.DayPicker-Months{display:flex;flex-wrap:wrap;justify-content:center}.DayPicker-Month{display:table;border-collapse:collapse;border-spacing:0;-webkit-user-select:none;-ms-user-select:none;user-select:none;margin:8px 8px 0}.DayPicker-Weekdays{display:table-header-group}.DayPicker-WeekdaysRow{display:table-row}.DayPicker-Weekday{display:table-cell;padding:8px;font-size:12px;text-align:center;color:#999}.DayPicker-Weekday abbr[title]{border-bottom:none;text-decoration:none}.DayPicker-Body{display:table-row-group}.DayPicker-Week{display:table-row}.DayPicker-Day{display:table-cell;line-height:15px;padding:8px;text-align:center;cursor:pointer;vertical-align:top;outline:none}.DayPicker--interactionDisabled .DayPicker-Day{cursor:default}.DayPicker-Footer{padding-top:8px}.DayPicker-Day--today{font-weight:700}.DayPicker-Day--outside{cursor:default;color:#8b9898}.DayPicker-Day--disabled{color:#cdcdcd;cursor:not-allowed}.DayPicker-Day--sunday{background-color:#f7f8f8}.DayPicker-Day--sunday:not(.DayPicker-Day--today){color:#dce0e0}.DayPicker-Day--selected:not(.DayPicker-Day--disabled):not(.DayPicker-Day--outside){background-color:#4b9fd5;color:#fff}.DayPicker:not(.DayPicker--interactionDisabled) .DayPicker-Day:not(.DayPicker-Day--disabled):not(.DayPicker-Day--selected):not(.DayPicker-Day--highlighted):not(.DayPicker-Day--outside):hover{background-color:#f3f3f3}.DayPicker-Day--highlighted:not(.DayPicker-Day--disabled):not(.DayPicker-Day--selected):not(.DayPicker-Day--outside){background-color:#cae3f2}",""]),e.exports=t},522:function(e,t,a){var n=a(313),s=a(523);"string"==typeof(s=s.__esModule?s.default:s)&&(s=[[e.i,s,""]]);var r={insert:"head",singleton:!1},o=(n(s,r),s.locals?s.locals:{});e.exports=o},523:function(e,t,a){(t=a(314)(!1)).push([e.i,".date-input-control{position:relative;display:inline-block;cursor:pointer}.date-input-control-input{width:130px;padding-left:24px!important;cursor:pointer}.date-input-control-input.is-filled{padding-right:16px!important}.date-input-control-icon{position:absolute;top:4px;left:4px}.date-input-control-icon path{fill:#cdcdcd;transition:fill .3s ease}.date-input-control-input:focus+.date-input-control-icon path{fill:#4b9fd5}.date-input-control-reset{position:absolute;top:4px;right:4px;border:none}.date-input-calendar{position:absolute;z-index:7500;top:100%;left:0;border:1px solid #e6e6e6;background-color:#fff;box-shadow:0 6px 12px rgba(0,0,0,.175)}.date-input-calendar-nav{display:flex;justify-content:space-between;align-items:center;padding-top:8px;padding-left:8px;padding-right:8px}.date-input-calender-month-select{width:70px}",""]),e.exports=t},574:function(e,t,a){"use strict";a.d(t,"e",(function(){return n})),a.d(t,"a",(function(){return s})),a.d(t,"b",(function(){return r})),a.d(t,"d",(function(){return o})),a.d(t,"c",(function(){return l}));const n={ALL:"__ALL__",ALL_EXCEPT_PENDING:"__ALL_EXCEPT_PENDING__"},s="ALL_TYPES",r={ALL:"__ALL__",ONLY_CURRENTS:"CURRENTS"},o={status:n.ALL_EXCEPT_PENDING,taskType:s,currents:r.ALL,minSubmittedAt:void 0,maxExecutedAt:void 0,query:""},l=250},611:function(e,t,a){"use strict";a.d(t,"a",(function(){return l}));var n=a(311),s=a(2),r=a(31),o=a(518);class l extends s.PureComponent{constructor(){super(...arguments),this.handleFromChange=e=>{this.props.onChange({from:e,to:this.to}),setTimeout(()=>{e&&!this.to&&this.toDateInput&&this.toDateInput.focus()},0)},this.handleToChange=e=>{this.props.onChange({from:this.from,to:e})}}get from(){return this.props.value&&this.props.value.from}get to(){return this.props.value&&this.props.value.to}render(){return s.createElement("div",{className:n("display-inline-flex-center",this.props.className)},s.createElement(o.a,{currentMonth:this.to,"data-test":"from",highlightTo:this.to,maxDate:this.to,onChange:this.handleFromChange,placeholder:Object(r.translate)("start_date"),value:this.from}),s.createElement("span",{className:"note little-spacer-left little-spacer-right"},Object(r.translate)("to_")),s.createElement(o.a,{currentMonth:this.from,"data-test":"to",highlightFrom:this.from,minDate:this.from,onChange:this.handleToChange,placeholder:Object(r.translate)("end_date"),ref:e=>this.toDateInput=e,value:this.to}))}}},772:function(e,t,a){"use strict";var n=a(2),s=a(323),r=a(325),o=a(759);function l(e){const{link:t=!0,organization:a,shouldBeDisplayed:s}=e;return s&&a?n.createElement("span",null,t?n.createElement(o.a,{className:e.linkClassName,organization:a},a.name):a.name,n.createElement("span",{className:"slash-separator"})):null}t.a=Object(s.connect)((e,t)=>({organization:Object(r.getOrganizationByKey)(e,t.organizationKey),shouldBeDisplayed:Object(r.areThereCustomOrganizations)(e)}))(l)}}]);
//# sourceMappingURL=310.m.6c943846.chunk.js.map