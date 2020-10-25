(window.webpackJsonp=window.webpackJsonp||[]).push([[314],{1846:function(e,t,s){"use strict";s.r(t),s.d(t,"App",(function(){return re}));var n=s(2),r=s(323),i=s(31),a=s(468),o=s(335),l=s(942),c=s(325),p=(s(738),s(328)),m=s.n(p);function u(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),s.push.apply(s,n)}return s}function d(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?u(Object(s),!0).forEach((function(t){h(e,t,s[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):u(Object(s)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))}))}return e}function h(e,t,s){return t in e?Object.defineProperty(e,t,{value:s,enumerable:!0,configurable:!0,writable:!0}):e[t]=s,e}const g=["user","codeviewer","issueadmin","securityhotspotadmin","admin","scan"];var f=s(332),b=s(312),j=s(364),E=s(333),y=s.n(E),O=s(317),v=s.n(O);class P extends n.PureComponent{constructor(e){super(e),this.mounted=!1,this.handleSubmit=()=>this.props.onSubmit({description:this.state.description,name:this.state.name,projectKeyPattern:this.state.projectKeyPattern}).then(this.props.onClose),this.handleNameChange=e=>{this.setState({name:e.currentTarget.value})},this.handleDescriptionChange=e=>{this.setState({description:e.currentTarget.value})},this.handleProjectKeyPatternChange=e=>{this.setState({projectKeyPattern:e.currentTarget.value})},this.state={description:e.permissionTemplate&&e.permissionTemplate.description||"",name:e.permissionTemplate&&e.permissionTemplate.name||"",projectKeyPattern:e.permissionTemplate&&e.permissionTemplate.projectKeyPattern||""}}render(){return n.createElement(y.a,{header:this.props.header,onClose:this.props.onClose,onSubmit:this.handleSubmit,size:"small"},({onCloseClick:e,onFormSubmit:t,submitting:s})=>n.createElement("form",{id:"permission-template-form",onSubmit:t},n.createElement("header",{className:"modal-head"},n.createElement("h2",null,this.props.header)),n.createElement("div",{className:"modal-body"},n.createElement("div",{className:"modal-field"},n.createElement("label",{htmlFor:"permission-template-name"},Object(i.translate)("name"),n.createElement("em",{className:"mandatory"},"*")),n.createElement("input",{autoFocus:!0,id:"permission-template-name",maxLength:256,name:"name",onChange:this.handleNameChange,required:!0,type:"text",value:this.state.name}),n.createElement("div",{className:"modal-field-description"},Object(i.translate)("should_be_unique"))),n.createElement("div",{className:"modal-field"},n.createElement("label",{htmlFor:"permission-template-description"},Object(i.translate)("description")),n.createElement("textarea",{id:"permission-template-description",name:"description",onChange:this.handleDescriptionChange,value:this.state.description})),n.createElement("div",{className:"modal-field"},n.createElement("label",{htmlFor:"permission-template-project-key-pattern"},Object(i.translate)("permission_template.key_pattern")),n.createElement("input",{id:"permission-template-project-key-pattern",maxLength:500,name:"projectKeyPattern",onChange:this.handleProjectKeyPatternChange,type:"text",value:this.state.projectKeyPattern}),n.createElement("div",{className:"modal-field-description"},Object(i.translate)("permission_template.key_pattern.description")))),n.createElement("footer",{className:"modal-foot"},n.createElement(v.a,{className:"spacer-right",loading:s}),n.createElement(b.SubmitButton,{disabled:s,id:"permission-template-submit"},this.props.confirmButtonText),n.createElement(b.ResetButtonLink,{disabled:s,id:"permission-template-cancel",onClick:e},Object(i.translate)("cancel")))))}}function _(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),s.push.apply(s,n)}return s}function k(e,t,s){return t in e?Object.defineProperty(e,t,{value:s,enumerable:!0,configurable:!0,writable:!0}):e[t]=s,e}class C extends n.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={createModal:!1},this.handleCreateClick=()=>{this.setState({createModal:!0})},this.handleCreateModalClose=()=>{this.mounted&&this.setState({createModal:!1})},this.handleCreateModalSubmit=e=>{const t=this.props.organization&&this.props.organization.key;return Object(a.f)(function(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?_(Object(s),!0).forEach((function(t){k(e,t,s[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):_(Object(s)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))}))}return e}({},e,{organization:t})).then(e=>{this.props.refresh().then(()=>{const s=t?"/organizations/".concat(t,"/permission_templates"):"/permission_templates";this.props.router.push({pathname:s,query:{id:e.permissionTemplate.id}})})})}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){return n.createElement("header",{className:"page-header",id:"project-permissions-header"},n.createElement("h1",{className:"page-title"},Object(i.translate)("permission_templates.page")),!this.props.ready&&n.createElement("i",{className:"spinner"}),n.createElement("div",{className:"page-actions"},n.createElement(b.Button,{onClick:this.handleCreateClick},Object(i.translate)("create")),this.state.createModal&&n.createElement(P,{confirmButtonText:Object(i.translate)("create"),header:Object(i.translate)("permission_template.new_template"),onClose:this.handleCreateModalClose,onSubmit:this.handleCreateModalSubmit})),n.createElement("p",{className:"page-description"},Object(i.translate)("permission_templates.page.description")))}}var S=Object(j.a)(C),N=s(324),w=s.n(N),T=s(322),x=s(433);class z extends n.PureComponent{renderTooltip(e){return"user"===e.key||"codeviewer"===e.key?n.createElement("div",null,n.createElement(x.a,{message:Object(i.translate)("projects_role",e.key,"desc")}),n.createElement(T.Alert,{className:"spacer-top",variant:"warning"},Object(i.translate)("projects_role.public_projects_warning"))):n.createElement(x.a,{message:Object(i.translate)("projects_role",e.key,"desc")})}render(){const e=this.props.permissions.map(e=>n.createElement("th",{className:"permission-column little-padded-left little-padded-right",key:e.key},n.createElement("div",{className:"permission-column-inner"},n.createElement("span",{className:"text-middle"},Object(i.translate)("projects_role",e.key)),n.createElement(w.a,{className:"spacer-left",overlay:this.renderTooltip(e)}))));return n.createElement("thead",null,n.createElement("tr",null,n.createElement("th",{className:"little-padded-left little-padded-right"}," "),e,n.createElement("th",{className:"thin nowrap text-right little-padded-left little-padded-right"}," ")))}}var D=s(388),q=s.n(D),F=s(383),I=s.n(F),M=s(344),U=s.n(M);function Q({onClose:e,onSubmit:t,permissionTemplate:s}){const r=Object(i.translate)("permission_template.delete_confirm_title");return n.createElement(y.a,{header:r,onClose:e,onSubmit:t},({onCloseClick:e,onFormSubmit:t,submitting:a})=>n.createElement("form",{onSubmit:t},n.createElement("header",{className:"modal-head"},n.createElement("h2",null,r)),n.createElement("div",{className:"modal-body"},Object(i.translateWithParameters)("permission_template.do_you_want_to_delete_template_xxx",s.name)),n.createElement("footer",{className:"modal-foot"},n.createElement(v.a,{className:"spacer-right",loading:a}),n.createElement(b.SubmitButton,{className:"button-red",disabled:a},Object(i.translate)("delete")),n.createElement(b.ResetButtonLink,{disabled:a,onClick:e},Object(i.translate)("cancel")))))}function L(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),s.push.apply(s,n)}return s}function K(e,t,s){return t in e?Object.defineProperty(e,t,{value:s,enumerable:!0,configurable:!0,writable:!0}):e[t]=s,e}class W extends n.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={deleteForm:!1,updateModal:!1},this.handleUpdateClick=()=>{this.setState({updateModal:!0})},this.handleCloseUpdateModal=()=>{this.mounted&&this.setState({updateModal:!1})},this.handleSubmitUpdateModal=e=>Object(a.y)(function(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?L(Object(s),!0).forEach((function(t){K(e,t,s[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):L(Object(s)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))}))}return e}({id:this.props.permissionTemplate.id},e)).then(this.props.refresh),this.handleDeleteClick=()=>{this.setState({deleteForm:!0})},this.handleCloseDeleteForm=()=>{this.mounted&&this.setState({deleteForm:!1})},this.handleDeleteSubmit=()=>Object(a.g)({templateId:this.props.permissionTemplate.id}).then(()=>{const e=this.props.organization?"/organizations/".concat(this.props.organization.key,"/permission_templates"):"/permission_templates";this.props.router.replace(e),this.props.refresh()}),this.setDefault=e=>()=>{Object(a.x)(this.props.permissionTemplate.id,e).then(this.props.refresh,()=>{})}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}getAvailableQualifiers(){const e=this.props.organization&&!this.props.organization.isDefault?["TRK"]:this.props.topQualifiers;return q()(e,this.props.permissionTemplate.defaultFor)}renderSetDefaultsControl(){const e=this.getAvailableQualifiers();return 0===e.length?null:1===this.props.topQualifiers.length?this.renderIfSingleTopQualifier(e):this.renderIfMultipleTopQualifiers(e)}renderSetDefaultLink(e,t){return n.createElement(F.ActionsDropdownItem,{className:"js-set-default","data-qualifier":e,key:e,onClick:this.setDefault(e)},t)}renderIfSingleTopQualifier(e){return e.map(e=>this.renderSetDefaultLink(e,n.createElement("span",null,Object(i.translate)("permission_templates.set_default"))))}renderIfMultipleTopQualifiers(e){return e.map(e=>this.renderSetDefaultLink(e,n.createElement("span",null,Object(i.translate)("permission_templates.set_default_for")," ",n.createElement(U.a,{qualifier:e})," ",Object(i.translate)("qualifiers",e))))}render(){const{permissionTemplate:e,organization:t}=this.props,s=t?"/organizations/".concat(t.key,"/permission_templates"):"/permission_templates";return n.createElement(n.Fragment,null,n.createElement(I.a,null,this.renderSetDefaultsControl(),!this.props.fromDetails&&n.createElement(F.ActionsDropdownItem,{to:{pathname:s,query:{id:e.id}}},Object(i.translate)("edit_permissions")),n.createElement(F.ActionsDropdownItem,{className:"js-update",onClick:this.handleUpdateClick},Object(i.translate)("update_details")),0===e.defaultFor.length&&n.createElement(F.ActionsDropdownItem,{className:"js-delete",destructive:!0,onClick:this.handleDeleteClick},Object(i.translate)("delete"))),this.state.updateModal&&n.createElement(P,{confirmButtonText:Object(i.translate)("update_verb"),header:Object(i.translate)("permission_template.edit_template"),onClose:this.handleCloseUpdateModal,onSubmit:this.handleSubmitUpdateModal,permissionTemplate:e}),this.state.deleteForm&&n.createElement(Q,{onClose:this.handleCloseDeleteForm,onSubmit:this.handleDeleteSubmit,permissionTemplate:e}))}}var A=Object(j.a)(W),H=s(316);function J({organization:e,template:t}){const s=e&&!e.isDefault?["TRK"]:t.defaultFor,r=m()(s).map(e=>Object(i.translate)("qualifiers",e)).join(", ");return n.createElement("div",null,n.createElement("span",{className:"badge spacer-right"},Object(i.translateWithParameters)("permission_template.default_for",r)))}function B({template:e,organization:t}){const s=t?"/organizations/".concat(t.key,"/permission_templates"):"/permission_templates";return n.createElement("td",{className:"little-padded-left little-padded-right"},n.createElement(H.Link,{to:{pathname:s,query:{id:e.id}}},n.createElement("strong",{className:"js-name"},e.name)),e.defaultFor.length>0&&n.createElement("div",{className:"spacer-top js-defaults"},n.createElement(J,{organization:t,template:e})),!!e.description&&n.createElement("div",{className:"spacer-top js-description"},e.description),!!e.projectKeyPattern&&n.createElement("div",{className:"spacer-top js-project-key-pattern"},"Project Key Pattern: ",n.createElement("code",null,e.projectKeyPattern)))}var G=s(6);function R({permission:e}){return n.createElement("td",{className:"permission-column little-padded-left little-padded-right"},n.createElement("div",{className:"permission-column-inner"},n.createElement("ul",null,e.withProjectCreator&&n.createElement("li",{className:"little-spacer-bottom display-flex-center"},Object(i.translate)("permission_templates.project_creators"),n.createElement(w.a,{className:"little-spacer-left",overlay:Object(i.translate)(Object(G.isSonarCloud)()?"permission_templates.project_creators.explanation.sonarcloud":"permission_templates.project_creators.explanation")})),n.createElement("li",{className:"little-spacer-bottom"},n.createElement("strong",null,e.usersCount),"  user(s)"),n.createElement("li",null,n.createElement("strong",null,e.groupsCount)," group(s)"))))}function V(e){const t=e.template.permissions.map(e=>n.createElement(R,{key:e.key,permission:e}));return n.createElement("tr",{"data-id":e.template.id,"data-name":e.template.name},n.createElement(B,{organization:e.organization,template:e.template}),t,n.createElement("td",{className:"nowrap thin text-right text-top little-padded-left little-padded-right"},n.createElement(A,{organization:e.organization,permissionTemplate:e.template,refresh:e.refresh,topQualifiers:e.topQualifiers})))}function X(e){const t=e.permissionTemplates.map(t=>n.createElement(V,{key:t.id,organization:e.organization,refresh:e.refresh,template:t,topQualifiers:e.topQualifiers}));return n.createElement("div",{className:"boxed-group boxed-group-inner"},n.createElement("table",{className:"data zebra permissions-table",id:"permission-templates"},n.createElement(z,{organization:e.organization,permissions:e.permissions}),n.createElement("tbody",null,t)))}function Y(e){return n.createElement("div",{className:"page page-limited"},n.createElement(f.a,{defer:!1,title:Object(i.translate)("permission_templates.page")}),n.createElement(S,{organization:e.organization,ready:e.ready,refresh:e.refresh}),n.createElement(X,{organization:e.organization,permissionTemplates:e.permissionTemplates,permissions:e.permissions,refresh:e.refresh,topQualifiers:e.topQualifiers}))}var Z=s(747),$=s(740),ee=s(402);function te({organization:e,template:t}){return n.createElement("div",{className:"big-spacer-bottom"},t.defaultFor.length>0&&n.createElement("div",{className:"spacer-top js-defaults"},n.createElement(J,{organization:e,template:t})),!!t.description&&n.createElement("div",{className:"spacer-top js-description"},t.description),!!t.projectKeyPattern&&n.createElement("div",{className:"spacer-top js-project-key-pattern"},"Project Key Pattern: ",n.createElement("code",null,t.projectKeyPattern)))}function se(e){const{template:t,organization:s}=e,r=s?"/organizations/".concat(s.key,"/permission_templates"):"/permission_templates";return n.createElement("header",{className:"page-header",id:"project-permissions-header"},n.createElement("div",{className:"note spacer-bottom"},n.createElement(H.Link,{className:"text-muted",to:r},Object(i.translate)("permission_templates.page"))),n.createElement("h1",{className:"page-title"},t.name),e.loading&&n.createElement("i",{className:"spinner"}),n.createElement("div",{className:"pull-right"},n.createElement(A,{fromDetails:!0,organization:s,permissionTemplate:t,refresh:e.refresh,topQualifiers:e.topQualifiers})))}class ne extends n.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={filter:"all",groups:[],loading:!1,query:"",users:[]},this.requestHolders=e=>{this.setState({loading:!0});const{template:t}=this.props,{query:s,filter:n,selectedPermission:r}=this.state,i=[],o=null!=e?e:s;return"groups"!==n?i.push(a.k(t.id,o,r)):i.push(Promise.resolve([])),"users"!==n?i.push(a.j(t.id,o,r)):i.push(Promise.resolve([])),Promise.all(i).then(e=>{this.mounted&&this.setState({users:e[0],groups:e[1],loading:!1})})},this.handleToggleUser=(e,t)=>{if("<creator>"===e.login)return this.handleToggleProjectCreator(e,t);const{template:s,organization:n}=this.props,r=e.permissions.includes(t),i={templateId:s.id,login:e.login,permission:t};return n&&(i.organization=n.key),(r?a.w(i):a.r(i)).then(()=>this.requestHolders()).then(this.props.refresh)},this.handleToggleProjectCreator=(e,t)=>{const{template:s}=this.props;return(e.permissions.includes(t)?a.s(s.id,t):a.a(s.id,t)).then(()=>this.requestHolders()).then(this.props.refresh)},this.handleToggleGroup=(e,t)=>{const{template:s,organization:n}=this.props,r=e.permissions.includes(t),i={templateId:s.id,groupName:e.name,permission:t};return n&&Object.assign(i,{organization:n.key}),(r?a.v(i):a.q(i)).then(()=>this.requestHolders()).then(this.props.refresh)},this.handleSearch=e=>{this.setState({query:e}),this.requestHolders(e)},this.handleFilter=e=>{this.setState({filter:e},this.requestHolders)},this.handleSelectPermission=e=>{e===this.state.selectedPermission?this.setState({selectedPermission:void 0},this.requestHolders):this.setState({selectedPermission:e},this.requestHolders)},this.shouldDisplayCreator=e=>{const{filter:t,query:s,selectedPermission:n}=this.state,r=Object(i.translate)("permission_templates.project_creators"),a="all"!==t,o=!s||r.toLocaleLowerCase().includes(s.toLowerCase()),l=void 0===n||e.includes(n);return!a&&o&&l}}componentDidMount(){this.mounted=!0,this.requestHolders()}componentWillUnmount(){this.mounted=!1}render(){const e=Object(ee.e)(ee.b,"projects_role"),t=[...this.state.users],s=this.props.template.permissions.filter(e=>e.withProjectCreator).map(e=>e.key);if(this.shouldDisplayCreator(s)){const e={login:"<creator>",name:Object(i.translate)("permission_templates.project_creators"),permissions:s};t.unshift(e)}return n.createElement("div",{className:"page page-limited"},n.createElement(f.a,{defer:!1,title:this.props.template.name}),n.createElement(se,{loading:this.state.loading,organization:this.props.organization,refresh:this.props.refresh,template:this.props.template,topQualifiers:this.props.topQualifiers}),n.createElement(te,{organization:this.props.organization,template:this.props.template}),n.createElement(Z.a,{groups:this.state.groups,onSelectPermission:this.handleSelectPermission,onToggleGroup:this.handleToggleGroup,onToggleUser:this.handleToggleUser,permissions:e,selectedPermission:this.state.selectedPermission,showPublicProjectsWarning:!0,users:t},n.createElement($.a,{filter:this.state.filter,onFilter:this.handleFilter,onSearch:this.handleSearch,query:this.state.query})))}}class re extends n.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={ready:!1,permissions:[],permissionTemplates:[]},this.requestPermissions=()=>{const{organization:e}=this.props;return(e?Object(a.l)(e.key):Object(a.l)()).then(e=>{if(this.mounted){const t=function(e){return m()(e,e=>g.indexOf(e.key))}(e.permissions),s=function(e,t=[]){return e.map(e=>{const s=[];return t.forEach(t=>{t.templateId===e.id&&s.push(t.qualifier)}),d({},e,{defaultFor:s})})}(function(e,t){return e.map(e=>{const s=t.map(t=>{const s=e.permissions.find(e=>e.key===t.key);return d({usersCount:0,groupsCount:0},t,{},s)});return d({},e,{permissions:s})})}(e.permissionTemplates,t),e.defaultTemplates);this.setState({ready:!0,permissionTemplates:s,permissions:t})}})}}componentDidMount(){this.mounted=!0,this.requestPermissions()}componentWillUnmount(){this.mounted=!1}renderTemplate(e){if(!this.state.ready)return null;const t=this.state.permissionTemplates.find(t=>t.id===e);return t?n.createElement(ne,{organization:this.props.organization,refresh:this.requestPermissions,template:t,topQualifiers:this.props.topQualifiers}):null}renderHome(){return n.createElement(Y,{organization:this.props.organization,permissionTemplates:this.state.permissionTemplates,permissions:this.state.permissions,ready:this.state.ready,refresh:this.requestPermissions,topQualifiers:this.props.topQualifiers})}render(){const{id:e}=this.props.location.query;return n.createElement("div",null,n.createElement(o.a,{suggestions:"permission_templates"}),n.createElement(l.a,{organization:this.props.organization,title:Object(i.translate)("permission_templates.page")}),e&&this.renderTemplate(e),!e&&this.renderHome())}}t.default=Object(r.connect)(e=>({topQualifiers:Object(c.getAppState)(e).qualifiers}))(re)},335:function(e,t,s){"use strict";s.d(t,"a",(function(){return i}));var n=s(2),r=s(368);function i({suggestions:e}){return n.createElement(r.a.Consumer,null,({addSuggestions:t,removeSuggestions:s})=>n.createElement(a,{addSuggestions:t,removeSuggestions:s,suggestions:e}))}class a extends n.PureComponent{componentDidMount(){this.props.addSuggestions(this.props.suggestions)}componentDidUpdate(e){e.suggestions!==this.props.suggestions&&(this.props.removeSuggestions(this.props.suggestions),this.props.addSuggestions(e.suggestions))}componentWillUnmount(){this.props.removeSuggestions(this.props.suggestions)}render(){return null}}},402:function(e,t,s){"use strict";s.d(t,"b",(function(){return i})),s.d(t,"c",(function(){return a})),s.d(t,"d",(function(){return o})),s.d(t,"a",(function(){return c})),s.d(t,"e",(function(){return m})),s.d(t,"f",(function(){return u}));var n=s(31),r=s(6);const i=["user","codeviewer","issueadmin","securityhotspotadmin","admin","scan"],a=["admin",{category:"administer",permissions:["gateadmin","profileadmin"]},"scan",{category:"creator",permissions:["provisioning"]}],o=["admin",{category:"administer",permissions:["gateadmin","profileadmin"]},"scan",{category:"creator",permissions:["provisioning","applicationcreator","portfoliocreator"]}],l=["user","admin"],c={TRK:i,VW:l,SVW:l,APP:l,DEV:["user","admin"]};function p(e,t){const s=e=>{const t="".concat(e,".sonarcloud");return Object(r.isSonarCloud)()&&Object(n.hasMessage)(t)?Object(n.translate)(t):Object(n.translate)(e)};return{key:e,name:s("".concat(t,".").concat(e)),description:s("".concat(t,".").concat(e,".desc"))}}function m(e,t){return e.map(e=>"object"==typeof e?{category:e.category,permissions:e.permissions.map(e=>p(e,t))}:p(e,t))}function u(e){return Boolean(e&&e.category)}},468:function(e,t,s){"use strict";s.d(t,"p",(function(){return i})),s.d(t,"u",(function(){return a})),s.d(t,"o",(function(){return o})),s.d(t,"t",(function(){return l})),s.d(t,"l",(function(){return c})),s.d(t,"f",(function(){return p})),s.d(t,"y",(function(){return m})),s.d(t,"g",(function(){return u})),s.d(t,"x",(function(){return d})),s.d(t,"b",(function(){return h})),s.d(t,"c",(function(){return g})),s.d(t,"r",(function(){return f})),s.d(t,"w",(function(){return b})),s.d(t,"q",(function(){return j})),s.d(t,"v",(function(){return E})),s.d(t,"a",(function(){return y})),s.d(t,"s",(function(){return O})),s.d(t,"n",(function(){return v})),s.d(t,"m",(function(){return P})),s.d(t,"i",(function(){return _})),s.d(t,"h",(function(){return k})),s.d(t,"k",(function(){return C})),s.d(t,"j",(function(){return S})),s.d(t,"e",(function(){return N})),s.d(t,"d",(function(){return w}));var n=s(9),r=s(326);function i(e){return Object(n.post)("/api/permissions/add_user",e).catch(r.a)}function a(e){return Object(n.post)("/api/permissions/remove_user",e).catch(r.a)}function o(e){return Object(n.post)("/api/permissions/add_group",e).catch(r.a)}function l(e){return Object(n.post)("/api/permissions/remove_group",e).catch(r.a)}function c(e){const t="/api/permissions/search_templates";return e?Object(n.getJSON)(t,{organization:e}):Object(n.getJSON)(t)}function p(e){return Object(n.postJSON)("/api/permissions/create_template",e)}function m(e){return Object(n.post)("/api/permissions/update_template",e)}function u(e){return Object(n.post)("/api/permissions/delete_template",e).catch(r.a)}function d(e,t){return Object(n.post)("/api/permissions/set_default_template",{templateId:e,qualifier:t})}function h(e){return Object(n.post)("/api/permissions/apply_template",e).catch(r.a)}function g(e){return Object(n.post)("/api/permissions/bulk_apply_template",e)}function f(e){return Object(n.post)("/api/permissions/add_user_to_template",e)}function b(e){return Object(n.post)("/api/permissions/remove_user_from_template",e)}function j(e){return Object(n.post)("/api/permissions/add_group_to_template",e)}function E(e){return Object(n.post)("/api/permissions/remove_group_from_template",e)}function y(e,t){return Object(n.post)("/api/permissions/add_project_creator_to_template",{templateId:e,permission:t})}function O(e,t){return Object(n.post)("/api/permissions/remove_project_creator_from_template",{templateId:e,permission:t})}function v(e){return e.ps||(e.ps=100),Object(n.getJSON)("/api/permissions/users",e).catch(r.a)}function P(e){return e.ps||(e.ps=100),Object(n.getJSON)("/api/permissions/groups",e).catch(r.a)}function _(e){return e.ps||(e.ps=100),Object(n.getJSON)("/api/permissions/users",e)}function k(e){return e.ps||(e.ps=100),Object(n.getJSON)("/api/permissions/groups",e)}function C(e,t,s,r){const i={templateId:e,ps:100};return t&&(i.q=t),s&&(i.permission=s),r&&Object.assign(i,{organization:r}),Object(n.getJSON)("/api/permissions/template_users",i).then(e=>e.users)}function S(e,t,s,r){const i={templateId:e,ps:100};return t&&(i.q=t),s&&(i.permission=s),r&&Object.assign(i,{organization:r}),Object(n.getJSON)("/api/permissions/template_groups",i).then(e=>e.groups)}function N(e,t){return Object(n.post)("/api/projects/update_visibility",{project:e,visibility:t}).catch(r.a)}function w(e,t){return Object(n.post)("/api/projects/update_default_visibility",{organization:e,projectVisibility:t}).catch(r.a)}},738:function(e,t,s){var n=s(313),r=s(739);"string"==typeof(r=r.__esModule?r.default:r)&&(r=[[e.i,r,""]]);var i={insert:"head",singleton:!1},a=(n(r,i),r.locals?r.locals:{});e.exports=a},739:function(e,t,s){(t=s(314)(!1)).push([e.i,'.permissions-table .permission-column.selected{background-color:#d9edf7}.permissions-table .permission-column-inner{width:100px}.permissions-table .divider{background:#fff;padding:16px 0}.permissions-table .divider:after{display:block;content:"";background:#e6e6e6;height:1px;width:100%}',""]),e.exports=t},740:function(e,t,s){"use strict";s.d(t,"a",(function(){return c}));var n=s(2),r=s(392),i=s.n(r),a=s(350),o=s.n(a),l=s(31);function c(e){const t=[{value:"all",label:Object(l.translate)("all")},{value:"users",label:Object(l.translate)("users.page")},{value:"groups",label:Object(l.translate)("user_groups.page")}];return n.createElement("div",{className:"display-flex-row"},n.createElement(i.a,{name:"users-or-groups",onCheck:e.onFilter,options:t,value:e.filter}),n.createElement("div",{className:"flex-1 spacer-left"},n.createElement(o.a,{minLength:3,onChange:e.onSearch,placeholder:Object(l.translate)("search.search_for_users_or_groups"),value:e.query})))}},747:function(e,t,s){"use strict";s.d(t,"a",(function(){return z}));var n=s(328),r=s.n(n),i=s(476),a=s.n(i),o=s(2),l=s(31),c=s(402),p=s(360),m=s.n(p),u=s(591),d=s.n(u),h=s(311),g=s(341),f=s.n(g);class b extends o.PureComponent{render(){const{loading:e,onCheck:t,permission:s,permissionItem:n,selectedPermission:r}=this.props;return Object(c.f)(s)?o.createElement("td",{className:"text-middle"},s.permissions.map(s=>o.createElement("div",{key:s.key},o.createElement(f.a,{checked:n.permissions.includes(s.key),disabled:e.includes(s.key),id:s.key,onCheck:t},o.createElement("span",{className:"little-spacer-left"},s.name))))):o.createElement("td",{className:h("permission-column text-center text-middle",{selected:s.key===r})},o.createElement(f.a,{checked:n.permissions.includes(s.key),disabled:e.includes(s.key),id:s.key,onCheck:t}))}}class j extends o.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:[]},this.stopLoading=e=>{this.mounted&&this.setState(t=>({loading:m()(t.loading,e)}))},this.handleCheck=(e,t)=>{void 0!==t&&(this.setState(e=>({loading:[...e.loading,t]})),this.props.onToggle(this.props.group,t).then(()=>this.stopLoading(t),()=>this.stopLoading(t)))}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const{group:e}=this.props;return o.createElement("tr",null,o.createElement("td",{className:"nowrap text-middle"},o.createElement("div",{className:"display-inline-block text-middle big-spacer-right"},o.createElement(d.a,null)),o.createElement("div",{className:"display-inline-block text-middle"},o.createElement("div",null,o.createElement("strong",null,e.name)),o.createElement("div",{className:"little-spacer-top",style:{whiteSpace:"normal"}},e.description))),this.props.permissions.map(t=>o.createElement(b,{key:Object(c.f)(t)?t.category:t.key,loading:this.state.loading,onCheck:this.handleCheck,permission:t,permissionItem:e,selectedPermission:this.props.selectedPermission})))}}var E=s(324),y=s.n(E),O=s(318),v=s.n(O),P=s(322),_=s(433);class k extends o.PureComponent{constructor(){super(...arguments),this.handlePermissionClick=e=>{e.preventDefault(),e.currentTarget.blur();const{permission:t}=this.props;this.props.onSelectPermission&&!Object(c.f)(t)&&this.props.onSelectPermission(t.key)},this.getTooltipOverlay=()=>{const{permission:e}=this.props;return Object(c.f)(e)?e.permissions.map(e=>o.createElement(o.Fragment,{key:e.key},o.createElement("b",{className:"little-spacer-right"},e.name,":"),o.createElement(_.a,{key:e.key,message:e.description}),o.createElement("br",null))):this.props.showPublicProjectsWarning&&["user","codeviewer"].includes(e.key)?o.createElement("div",null,o.createElement(_.a,{message:e.description}),o.createElement(P.Alert,{className:"spacer-top",variant:"warning"},Object(l.translate)("projects_role.public_projects_warning"))):o.createElement(_.a,{message:e.description})}}render(){const{onSelectPermission:e,permission:t}=this.props;let s;return s=Object(c.f)(t)?Object(l.translate)("global_permissions",t.category):e?o.createElement(v.a,{overlay:Object(l.translateWithParameters)("global_permissions.filter_by_x_permission",t.name)},o.createElement("a",{href:"#",onClick:this.handlePermissionClick},t.name)):t.name,o.createElement("th",{className:h("permission-column text-center text-middle",{selected:!Object(c.f)(t)&&t.key===this.props.selectedPermission})},o.createElement("div",{className:"permission-column-inner"},s,o.createElement(y.a,{className:"spacer-left",overlay:this.getTooltipOverlay()})))}}var C=s(375),S=s(6);class N extends o.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:[]},this.stopLoading=e=>{this.mounted&&this.setState(t=>({loading:m()(t.loading,e)}))},this.handleCheck=(e,t)=>{void 0!==t&&(this.setState(e=>({loading:[...e.loading,t]})),this.props.onToggle(this.props.user,t).then(()=>this.stopLoading(t),()=>this.stopLoading(t)))}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const{user:e}=this.props,t=this.props.permissions.map(t=>o.createElement(b,{key:Object(c.f)(t)?t.category:t.key,loading:this.state.loading,onCheck:this.handleCheck,permission:t,permissionItem:e,selectedPermission:this.props.selectedPermission}));return"<creator>"===e.login?o.createElement("tr",null,o.createElement("td",{className:"nowrap text-middle"},o.createElement("div",{className:"display-inline-block text-middle"},o.createElement("div",null,o.createElement("strong",null,e.name)),o.createElement("div",{className:"little-spacer-top",style:{whiteSpace:"normal"}},Object(l.translate)(Object(S.isSonarCloud)()?"permission_templates.project_creators.explanation.sonarcloud":"permission_templates.project_creators.explanation")))),t):o.createElement("tr",null,o.createElement("td",{className:"nowrap text-middle"},o.createElement(C.a,{className:"text-middle big-spacer-right",hash:e.avatar,name:e.name,size:36}),o.createElement("div",{className:"display-inline-block text-middle"},Object(S.isSonarCloud)()?o.createElement(o.Fragment,null,o.createElement("div",null,o.createElement("strong",null,e.name)),o.createElement("div",{className:"note little-spacer-top"},e.login)):o.createElement(o.Fragment,null,o.createElement("div",null,o.createElement("strong",null,e.name),o.createElement("span",{className:"note spacer-left"},e.login)),o.createElement("div",{className:"little-spacer-top"},e.email)))),t)}}function w(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),s.push.apply(s,n)}return s}function T(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?w(Object(s),!0).forEach((function(t){x(e,t,s[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):w(Object(s)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))}))}return e}function x(e,t,s){return t in e?Object.defineProperty(e,t,{value:s,enumerable:!0,configurable:!0,writable:!0}):e[t]=s,e}class z extends o.PureComponent{constructor(){super(...arguments),this.state={initialPermissionsCount:{}},this.handleGroupToggle=(e,t)=>{const s=e.id||e.name;return void 0===this.state.initialPermissionsCount[s]&&this.setState(t=>({initialPermissionsCount:T({},t.initialPermissionsCount,{[s]:e.permissions.length})})),this.props.onToggleGroup(e,t)},this.handleUserToggle=(e,t)=>(void 0===this.state.initialPermissionsCount[e.login]&&this.setState(t=>({initialPermissionsCount:T({},t.initialPermissionsCount,{[e.login]:e.permissions.length})})),this.props.onToggleUser(e,t)),this.getItemInitialPermissionsCount=e=>{const t=this.isPermissionUser(e)?e.login:e.id||e.name;return void 0!==this.state.initialPermissionsCount[t]?this.state.initialPermissionsCount[t]:e.permissions.length}}componentDidUpdate(e){this.props.filter===e.filter&&this.props.query===e.query||this.setState({initialPermissionsCount:{}})}isPermissionUser(e){return void 0!==e.login}renderEmpty(){const e=this.props.permissions.length+1;return o.createElement("tr",null,o.createElement("td",{colSpan:e},Object(l.translate)("no_results_search")))}renderItem(e,t){return this.isPermissionUser(e)?o.createElement(N,{key:"user-".concat(e.login),onToggle:this.handleUserToggle,permissions:t,selectedPermission:this.props.selectedPermission,user:e}):o.createElement(j,{group:e,key:"group-".concat(e.id||e.name),onToggle:this.handleGroupToggle,permissions:t,selectedPermission:this.props.selectedPermission})}render(){const{permissions:e}=this.props,t=r()([...this.props.users,...this.props.groups],e=>this.isPermissionUser(e)&&"<creator>"===e.login?0:e.name),[s,n]=a()(t,e=>this.getItemInitialPermissionsCount(e));return o.createElement("div",{className:"boxed-group boxed-group-inner"},o.createElement("table",{className:"data zebra permissions-table"},o.createElement("thead",null,o.createElement("tr",null,o.createElement("td",{className:"nowrap bordered-bottom"},this.props.children),e.map(e=>o.createElement(k,{key:Object(c.f)(e)?e.category:e.key,onSelectPermission:this.props.onSelectPermission,permission:e,selectedPermission:this.props.selectedPermission,showPublicProjectsWarning:this.props.showPublicProjectsWarning})))),o.createElement("tbody",null,0===t.length&&!this.props.loading&&this.renderEmpty(),s.map(t=>this.renderItem(t,e)),s.length>0&&n.length>0&&o.createElement(o.Fragment,null,o.createElement("tr",null,o.createElement("td",{className:"divider",colSpan:20})),o.createElement("tr",null)),n.map(t=>this.renderItem(t,e)))))}}},942:function(e,t,s){"use strict";s.d(t,"a",(function(){return i}));var n=s(2),r=s(332);function i({title:e,organization:t}){const s=e+(t?" - "+t.name:"");return n.createElement(r.a,{defaultTitle:s,defer:!1,titleTemplate:"%s - ".concat(s)})}}}]);
//# sourceMappingURL=314.m.38c66889.chunk.js.map