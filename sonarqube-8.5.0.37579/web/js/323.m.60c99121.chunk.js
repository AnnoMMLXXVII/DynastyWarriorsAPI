(window.webpackJsonp=window.webpackJsonp||[]).push([[323],{1820:function(e,t,a){"use strict";a.r(t),a.d(t,"default",(function(){return r}));var n=a(2),s=a(930);function r(e){return n.createElement(s.a,Object.assign({setup:!0},e))}},359:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=a(449),s=a(2),r=a(319),c=a(26),i=a(31),l=a(357);t.default=function(e){var t=e.children,a=void 0===t?function(e){return e}:t,m=e.date,u=e.hourPrecision,o=a;if(!m)return s.createElement(s.Fragment,null,a(i.translate("never")));m&&u&&n.differenceInHours(Date.now(),m)<1&&(o=function(){return a(i.translate("less_than_1_hour_ago"))});var d=c.parseDate(m);return s.createElement(l.default,{date:d},(function(e){return s.createElement("span",{title:e},s.createElement(r.FormattedRelative,{value:d},o))}))}},516:function(e,t,a){"use strict";a.d(t,"g",(function(){return r})),a.d(t,"b",(function(){return c})),a.d(t,"c",(function(){return i})),a.d(t,"d",(function(){return l})),a.d(t,"a",(function(){return m})),a.d(t,"e",(function(){return u})),a.d(t,"f",(function(){return o})),a.d(t,"h",(function(){return d}));var n=a(9),s=a(326);function r(e){return Object(n.post)("/api/system/change_log_level",{level:e}).catch(s.a)}function c(){return Object(n.getJSON)("/api/system/info").catch(s.a)}function i(){return Object(n.getJSON)("/api/system/status")}function l(){return Object(n.getJSON)("/api/system/upgrades")}function m(){return Object(n.getJSON)("/api/system/db_migration_status")}function u(){return Object(n.postJSON)("/api/system/migrate_db")}function o(){return Object(n.post)("/api/system/restart").catch(s.a)}function d(){return Object(n.requestTryAndRepeatUntil)(i,{max:-1,slowThreshold:-15},({status:e})=>"UP"===e)}},556:function(e,t,a){"use strict";var n=this&&this.__assign||function(){return(n=Object.assign||function(e){for(var t,a=1,n=arguments.length;a<n;a++)for(var s in t=arguments[a])Object.prototype.hasOwnProperty.call(t,s)&&(e[s]=t[s]);return e}).apply(this,arguments)};Object.defineProperty(t,"__esModule",{value:!0});var s=a(2),r=a(319),c=a(26);t.formatterOption={hour:"numeric",minute:"numeric"},t.longFormatterOption={hour:"numeric",minute:"numeric",second:"numeric"},t.default=function(e){var a=e.children,i=e.date,l=e.long;return s.createElement(r.FormattedTime,n({value:c.parseDate(i)},l?t.longFormatterOption:t.formatterOption),a)}},930:function(e,t,a){"use strict";a.d(t,"a",(function(){return _}));var n=a(311),s=a(2),r=a(332),c=a(319),i=a(312),l=a(359),m=a.n(l),u=a(556),o=a.n(u),d=a(31),h=a(343),p=a(516),g=a(433),E=a(6);a(931);class _ extends s.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={},this.fetchStatus=()=>{(this.props.setup?this.fetchMigrationState():this.fetchSystemStatus()).catch(()=>{this.mounted&&this.setState({message:void 0,startedAt:void 0,state:void 0,status:"OFFLINE"})})},this.fetchSystemStatus=()=>Object(p.c)().then(({status:e})=>{this.mounted&&(this.setState({status:e}),"STARTING"===e?(this.setState({wasStarting:!0}),this.scheduleRefresh()):"UP"===e?this.state.wasStarting&&this.loadPreviousPage():this.scheduleRefresh())}),this.fetchMigrationState=()=>Object(p.a)().then(({message:e,startedAt:t,state:a})=>{this.mounted&&(this.setState({message:e,startedAt:t,state:a}),"MIGRATION_SUCCEEDED"===a?this.loadPreviousPage():"NO_MIGRATION"!==a&&this.scheduleRefresh())}),this.scheduleRefresh=()=>{this.interval=window.setTimeout(this.fetchStatus,5e3)},this.loadPreviousPage=()=>{setInterval(()=>{window.location.href=Object(h.getReturnUrl)(this.props.location)},2500)},this.handleMigrateClick=()=>{Object(p.e)().then(({message:e,startedAt:t,state:a})=>{this.mounted&&this.setState({message:e,startedAt:t,state:a})},()=>{})}}componentDidMount(){this.mounted=!0,this.fetchStatus()}componentWillUnmount(){this.mounted=!1,this.interval&&window.clearInterval(this.interval)}render(){const{state:e,status:t}=this.state;return s.createElement(s.Fragment,null,s.createElement(r.a,{defaultTitle:Object(d.translate)("maintenance.page"),defer:!1}),s.createElement("div",{className:"page-wrapper-simple",id:"bd"},s.createElement("div",{className:n("page-simple",{"panel-warning":"MIGRATION_REQUIRED"===e}),id:"nonav"},"OFFLINE"===t&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title text-danger"},s.createElement(g.a,{message:Object(d.translate)("maintenance.is_offline")})),!Object(E.isSonarCloud)()&&s.createElement("p",{className:"maintenance-text"},Object(d.translate)("maintenance.sonarqube_is_offline.text")),s.createElement("p",{className:"maintenance-text text-center"},s.createElement("a",{href:Object(h.getBaseUrl)()+"/"},Object(d.translate)("maintenance.try_again")))),"UP"===t&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title"},s.createElement(g.a,{message:Object(d.translate)("maintenance.is_up")})),s.createElement("p",{className:"maintenance-text text-center"},Object(d.translate)("maintenance.all_systems_opetational")),s.createElement("p",{className:"maintenance-text text-center"},s.createElement("a",{href:Object(h.getBaseUrl)()+"/"},Object(d.translate)("layout.home")))),"STARTING"===t&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title"},s.createElement(g.a,{message:Object(d.translate)("maintenance.is_starting")})),s.createElement("p",{className:"maintenance-spinner"},s.createElement("i",{className:"spinner"}))),"DOWN"===t&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title text-danger"},s.createElement(g.a,{message:Object(d.translate)("maintenance.is_down")})),s.createElement("p",{className:"maintenance-text"},Object(d.translate)("maintenance.sonarqube_is_down.text")),s.createElement("p",{className:"maintenance-text text-center"},s.createElement("a",{href:Object(h.getBaseUrl)()+"/"},Object(d.translate)("maintenance.try_again")))),("DB_MIGRATION_NEEDED"===t||"DB_MIGRATION_RUNNING"===t)&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title"},s.createElement(g.a,{message:Object(d.translate)("maintenance.is_under_maintenance")})),!Object(E.isSonarCloud)()&&s.createElement(s.Fragment,null,s.createElement("p",{className:"maintenance-text"},s.createElement(c.FormattedMessage,{defaultMessage:Object(d.translate)("maintenance.sonarqube_is_under_maintenance.1"),id:"maintenance.sonarqube_is_under_maintenance.1",values:{link:s.createElement("a",{href:"https://redirect.sonarsource.com/doc/plugin-library.html"},Object(d.translate)("maintenance.sonarqube_is_under_maintenance_link.1"))}})),s.createElement("p",{className:"maintenance-text"},s.createElement(c.FormattedMessage,{defaultMessage:Object(d.translate)("maintenance.sonarqube_is_under_maintenance.2"),id:"maintenance.sonarqube_is_under_maintenance.2",values:{link:s.createElement("a",{href:"https://redirect.sonarsource.com/doc/upgrading.html"},Object(d.translate)("maintenance.sonarqube_is_under_maintenance_link.2"))}})))),"NO_MIGRATION"===e&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title"},Object(d.translate)("maintenance.database_is_up_to_date")),s.createElement("p",{className:"maintenance-text text-center"},s.createElement("a",{href:Object(h.getBaseUrl)()+"/"},Object(d.translate)("layout.home")))),"MIGRATION_REQUIRED"===e&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title"},Object(d.translate)("maintenance.upgrade_database")),s.createElement("p",{className:"maintenance-text"},Object(d.translate)("maintenance.upgrade_database.1")),s.createElement("p",{className:"maintenance-text"},Object(d.translate)("maintenance.upgrade_database.2")),s.createElement("p",{className:"maintenance-text"},Object(d.translate)("maintenance.upgrade_database.3")),s.createElement("div",{className:"maintenance-spinner"},s.createElement(i.Button,{id:"start-migration",onClick:this.handleMigrateClick},Object(d.translate)("maintenance.upgrade")))),"NOT_SUPPORTED"===e&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title text-danger"},Object(d.translate)("maintenance.migration_not_supported")),s.createElement("p",null,Object(d.translate)("maintenance.migration_not_supported.text"))),"MIGRATION_RUNNING"===e&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title"},Object(d.translate)("maintenance.database_migration")),this.state.message&&s.createElement("p",{className:"maintenance-text text-center"},this.state.message),this.state.startedAt&&s.createElement("p",{className:"maintenance-text text-center"},Object(d.translate)("background_tasks.table.started")," ",s.createElement(m.a,{date:this.state.startedAt}),s.createElement("br",null),s.createElement("small",{className:"text-muted"},s.createElement(o.a,{date:this.state.startedAt,long:!0}))),s.createElement("p",{className:"maintenance-spinner"},s.createElement("i",{className:"spinner"}))),"MIGRATION_SUCCEEDED"===e&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title text-success"},Object(d.translate)("maintenance.database_is_up_to_date")),s.createElement("p",{className:"maintenance-text text-center"},s.createElement("a",{href:Object(h.getBaseUrl)()+"/"},Object(d.translate)("layout.home")))),"MIGRATION_FAILED"===e&&s.createElement(s.Fragment,null,s.createElement("h1",{className:"maintenance-title text-danger"},Object(d.translate)("maintenance.upgrade_failed")),s.createElement("p",{className:"maintenance-text"},Object(d.translate)("maintenance.upgrade_failed.text"))))))}}},931:function(e,t,a){var n=a(313),s=a(932);"string"==typeof(s=s.__esModule?s.default:s)&&(s=[[e.i,s,""]]);var r={insert:"head",singleton:!1},c=(n(s,r),s.locals?s.locals:{});e.exports=c},932:function(e,t,a){(t=a(314)(!1)).push([e.i,".maintenance-title{margin-bottom:40px;line-height:1.5;font-size:24px;font-weight:300;text-align:center}.maintenance-text{margin-bottom:16px;line-height:1.5;font-size:16px;font-weight:300}.maintenance-spinner{margin-top:40px;text-align:center}",""]),e.exports=t}}]);
//# sourceMappingURL=323.m.60c99121.chunk.js.map