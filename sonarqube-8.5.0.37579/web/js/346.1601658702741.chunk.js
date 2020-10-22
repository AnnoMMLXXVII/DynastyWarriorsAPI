(window.webpackJsonp=window.webpackJsonp||[]).push([[346],{1138:function(e,t,n){"use strict";n.d(t,"f",(function(){return a})),n.d(t,"d",(function(){return s})),n.d(t,"a",(function(){return i})),n.d(t,"e",(function(){return c})),n.d(t,"b",(function(){return u})),n.d(t,"g",(function(){return l})),n.d(t,"c",(function(){return p}));var r=n(49),o=n(675);function a(e){return Object(r.getJSON)("/api/user_groups/search",e).catch(o.a)}function s(e){return Object(r.getJSON)("/api/user_groups/users",e).catch(o.a)}function i(e){return Object(r.post)("/api/user_groups/add_user",e).catch(o.a)}function c(e){return Object(r.post)("/api/user_groups/remove_user",e).catch(o.a)}function u(e){return Object(r.postJSON)("/api/user_groups/create",e).then((function(e){return e.group}),o.a)}function l(e){return Object(r.post)("/api/user_groups/update",e).catch(o.a)}function p(e){return Object(r.post)("/api/user_groups/delete",e).catch(o.a)}},2208:function(e,t,n){"use strict";n.r(t);var r=n(13),o=n(681),a=n(696),s=n.n(a),i=n(701),c=n.n(i),u=n(176),l=n(49),p=n(1138),d=n(684),m=n(661),h=n(682),f=n.n(h),g=n(666),b=n.n(g);function E(e){var t=e.group,n=e.onClose,o=e.onSubmit,a=Object(u.translate)("groups.delete_group");return r.createElement(f.a,{header:a,onClose:n,onSubmit:o},(function(e){var n=e.onCloseClick,o=e.onFormSubmit,s=e.submitting;return r.createElement("form",{onSubmit:o},r.createElement("header",{className:"modal-head"},r.createElement("h2",null,a)),r.createElement("div",{className:"modal-body"},Object(u.translateWithParameters)("groups.delete_group.confirmation",t.name)),r.createElement("footer",{className:"modal-foot"},r.createElement(b.a,{className:"spacer-right",loading:s}),r.createElement(m.SubmitButton,{className:"button-red",disabled:s},Object(u.translate)("delete")),r.createElement(m.ResetButtonLink,{disabled:s,onClick:n},Object(u.translate)("cancel"))))}))}var v,y=(v=function(e,t){return(v=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}v(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),O=function(e){function t(t){var n=e.call(this,t)||this;return n.handleSubmit=function(){return n.props.onSubmit({description:n.state.description,name:n.state.name}).then(n.props.onClose)},n.handleDescriptionChange=function(e){n.setState({description:e.currentTarget.value})},n.handleNameChange=function(e){n.setState({name:e.currentTarget.value})},n.state={description:t.group&&t.group.description||"",name:t.group&&t.group.name||""},n}return y(t,e),t.prototype.render=function(){var e=this;return r.createElement(f.a,{header:this.props.header,onClose:this.props.onClose,onSubmit:this.handleSubmit,size:"small"},(function(t){var n=t.onCloseClick,o=t.onFormSubmit,a=t.submitting;return r.createElement("form",{onSubmit:o},r.createElement("header",{className:"modal-head"},r.createElement("h2",null,e.props.header)),r.createElement("div",{className:"modal-body"},r.createElement("div",{className:"modal-field"},r.createElement("label",{htmlFor:"create-group-name"},Object(u.translate)("name"),r.createElement("em",{className:"mandatory"},"*")),r.createElement("input",{autoFocus:!0,id:"create-group-name",maxLength:255,name:"name",onChange:e.handleNameChange,required:!0,size:50,type:"text",value:e.state.name})),r.createElement("div",{className:"modal-field"},r.createElement("label",{htmlFor:"create-group-description"},Object(u.translate)("description")),r.createElement("textarea",{id:"create-group-description",name:"description",onChange:e.handleDescriptionChange,value:e.state.description}))),r.createElement("footer",{className:"modal-foot"},r.createElement(b.a,{className:"spacer-right",loading:a}),r.createElement(m.SubmitButton,{disabled:a},e.props.confirmButtonText),r.createElement(m.ResetButtonLink,{onClick:n},Object(u.translate)("cancel"))))}))},t}(r.PureComponent),_=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),j=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={createModal:!1},t.handleCreateClick=function(){t.setState({createModal:!0})},t.handleClose=function(){t.mounted&&t.setState({createModal:!1})},t.handleSubmit=function(e){return t.props.onCreate(e)},t}return _(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){return r.createElement(r.Fragment,null,r.createElement("header",{className:"page-header",id:"groups-header"},r.createElement("h1",{className:"page-title"},Object(u.translate)("user_groups.page")),r.createElement("div",{className:"page-actions"},r.createElement(m.Button,{id:"groups-create",onClick:this.handleCreateClick},Object(u.translate)("groups.create_group"))),r.createElement("p",{className:"page-description"},Object(u.translate)("user_groups.page.description"))),this.state.createModal&&r.createElement(O,{confirmButtonText:Object(u.translate)("create"),header:Object(u.translate)("groups.create_group"),onClose:this.handleClose,onSubmit:this.handleSubmit}))},t}(r.PureComponent),S=n(678),C=n.n(S),w=n(732),N=n.n(w),D=n(948),k=n.n(D),P=n(718),F=n.n(P),M=n(853),x=n.n(M),T=n(679),U=n.n(T),q=n(855),G=n.n(q),B=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),A=function(){for(var e=0,t=0,n=arguments.length;t<n;t++)e+=arguments[t].length;var r=Array(e),o=0;for(t=0;t<n;t++)for(var a=arguments[t],s=0,i=a.length;s<i;s++,o++)r[o]=a[s];return r},R=function(e){function t(t){var n=e.call(this,t)||this;return n.mounted=!1,n.fetchUsers=function(e){return Object(p.d)({name:n.props.group.name,p:e.page,ps:e.pageSize,q:""!==e.query?e.query:void 0,selected:e.filter}).then((function(t){n.mounted&&n.setState((function(n){var r=null!=e.page&&e.page>1,o=r?A(n.users,t.users):t.users,a=t.users.filter((function(e){return e.selected})).map((function(e){return e.login})),s=r?A(n.selectedUsers,a):a;return{needToReload:!1,lastSearchParams:e,loading:!1,users:o,usersTotalCount:t.total,selectedUsers:s}}))}))},n.handleSelect=function(e){return Object(p.a)({name:n.props.group.name,login:e}).then((function(){n.mounted&&n.setState((function(t){return{needToReload:!0,selectedUsers:A(t.selectedUsers,[e])}}))}))},n.handleUnselect=function(e){return Object(p.e)({name:n.props.group.name,login:e}).then((function(){n.mounted&&n.setState((function(t){return{needToReload:!0,selectedUsers:F()(t.selectedUsers,e)}}))}))},n.renderElement=function(e){var t=x()(n.state.users,{login:e});return r.createElement("div",{className:"select-list-list-item"},void 0===t?e:r.createElement(r.Fragment,null,t.name,r.createElement("br",null),r.createElement("span",{className:"note"},t.login)))},n.state={needToReload:!1,users:[],selectedUsers:[]},n}return B(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=Object(u.translate)("users.update");return r.createElement(U.a,{contentLabel:e,onRequestClose:this.props.onClose},r.createElement("header",{className:"modal-head"},r.createElement("h2",null,e)),r.createElement("div",{className:"modal-body modal-container"},r.createElement(G.a,{elements:this.state.users.map((function(e){return e.login})),elementsTotalCount:this.state.usersTotalCount,needToReload:this.state.needToReload&&this.state.lastSearchParams&&this.state.lastSearchParams.filter!==q.SelectListFilter.All,onSearch:this.fetchUsers,onSelect:this.handleSelect,onUnselect:this.handleUnselect,renderElement:this.renderElement,selectedElements:this.state.selectedUsers,withPaging:!0})),r.createElement("footer",{className:"modal-foot"},r.createElement(m.ResetButtonLink,{onClick:this.props.onClose},Object(u.translate)("Done"))))},t}(r.PureComponent),L=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),I=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={modal:!1},t.handleMembersClick=function(){t.setState({modal:!0})},t.handleModalClose=function(){t.mounted&&(t.setState({modal:!1}),t.props.onEdit())},t}return L(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){return r.createElement(r.Fragment,null,r.createElement(m.ButtonIcon,{"aria-label":Object(u.translate)("groups.users.edit"),className:"button-small",onClick:this.handleMembersClick,title:Object(u.translate)("groups.users.edit")},r.createElement(k.a,null)),this.state.modal&&r.createElement(R,{group:this.props.group,onClose:this.handleModalClose}))},t}(r.PureComponent);function z(e){var t=e.group;return r.createElement("tr",{"data-id":t.name},r.createElement("td",{className:"width-20"},r.createElement("strong",{className:"js-group-name"},t.name),t.default&&r.createElement("span",{className:"little-spacer-left"},"(",Object(u.translate)("default"),")")),r.createElement("td",{className:"thin text-middle text-right little-padded-right"},t.membersCount),r.createElement("td",{className:"little-padded-left"},!t.default&&r.createElement(I,{group:t,onEdit:e.onEditMembers})),r.createElement("td",{className:"width-40"},r.createElement("span",{className:"js-group-description"},t.description)),r.createElement("td",{className:"thin nowrap text-right"},!t.default&&r.createElement(N.a,null,r.createElement(w.ActionsDropdownItem,{className:"js-group-update",onClick:function(){return e.onEdit(t)}},Object(u.translate)("update_details")),r.createElement(w.ActionsDropdownDivider,null),r.createElement(w.ActionsDropdownItem,{className:"js-group-delete",destructive:!0,onClick:function(){return e.onDelete(t)}},Object(u.translate)("delete")))))}function W(e){return r.createElement("div",{className:"boxed-group boxed-group-inner"},r.createElement("table",{className:"data zebra zebra-hover",id:"groups-list"},r.createElement("thead",null,r.createElement("tr",null,r.createElement("th",null),r.createElement("th",{className:"nowrap width-10",colSpan:2},Object(u.translate)("members")),r.createElement("th",{className:"nowrap"},Object(u.translate)("description")),r.createElement("th",null))),r.createElement("tbody",null,e.showAnyone&&r.createElement("tr",{className:"js-anyone",key:"anyone"},r.createElement("td",{className:"width-20"},r.createElement("strong",{className:"js-group-name"},Object(u.translate)("groups.anyone"))),r.createElement("td",{className:"width-10",colSpan:2}),r.createElement("td",{className:"width-40",colSpan:2},r.createElement("span",{className:"js-group-description"},Object(u.translate)("user_groups.anyone.description")))),C()(e.groups,(function(e){return e.name.toLowerCase()})).map((function(t){return r.createElement(z,{group:t,key:t.name,onDelete:e.onDelete,onEdit:e.onEdit,onEditMembers:e.onEditMembers})})))))}var J=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),H=function(){return(H=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var o in t=arguments[n])Object.prototype.hasOwnProperty.call(t,o)&&(e[o]=t[o]);return e}).apply(this,arguments)},K=function(e,t,n,r){return new(n||(n=Promise))((function(o,a){function s(e){try{c(r.next(e))}catch(e){a(e)}}function i(e){try{c(r.throw(e))}catch(e){a(e)}}function c(e){var t;e.done?o(e.value):(t=e.value,t instanceof n?t:new n((function(e){e(t)}))).then(s,i)}c((r=r.apply(e,t||[])).next())}))},Q=function(e,t){var n,r,o,a,s={label:0,sent:function(){if(1&o[0])throw o[1];return o[1]},trys:[],ops:[]};return a={next:i(0),throw:i(1),return:i(2)},"function"==typeof Symbol&&(a[Symbol.iterator]=function(){return this}),a;function i(a){return function(i){return function(a){if(n)throw new TypeError("Generator is already executing.");for(;s;)try{if(n=1,r&&(o=2&a[0]?r.return:a[0]?r.throw||((o=r.return)&&o.call(r),0):r.next)&&!(o=o.call(r,a[1])).done)return o;switch(r=0,o&&(a=[2&a[0],o.value]),a[0]){case 0:case 1:o=a;break;case 4:return s.label++,{value:a[1],done:!1};case 5:s.label++,r=a[1],a=[0];continue;case 7:a=s.ops.pop(),s.trys.pop();continue;default:if(!(o=(o=s.trys).length>0&&o[o.length-1])&&(6===a[0]||2===a[0])){s=0;continue}if(3===a[0]&&(!o||a[1]>o[0]&&a[1]<o[3])){s.label=a[1];break}if(6===a[0]&&s.label<o[1]){s.label=o[1],o=a;break}if(o&&s.label<o[2]){s.label=o[2],s.ops.push(a);break}o[2]&&s.ops.pop(),s.trys.pop();continue}a=t.call(e,s)}catch(e){a=[6,e],r=0}finally{n=o=0}if(5&a[0])throw a[1];return{value:a[0]?a[1]:void 0,done:!0}}([a,i])}}},V=function(){for(var e=0,t=0,n=arguments.length;t<n;t++)e+=arguments[t].length;var r=Array(e),o=0;for(t=0;t<n;t++)for(var a=arguments[t],s=0,i=a.length;s<i;s++,o++)r[o]=a[s];return r},X=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={loading:!0,query:""},t.makeFetchGroupsRequest=function(e){return t.setState({loading:!0}),Object(p.f)(H({q:t.state.query},e))},t.stopLoading=function(){t.mounted&&t.setState({loading:!1})},t.fetchGroups=function(e){return K(t,void 0,void 0,(function(){var t,n,r;return Q(this,(function(o){switch(o.label){case 0:return o.trys.push([0,2,,3]),[4,this.makeFetchGroupsRequest(e)];case 1:return t=o.sent(),n=t.groups,r=t.paging,this.mounted&&this.setState({groups:n,loading:!1,paging:r}),[3,3];case 2:return o.sent(),this.stopLoading(),[3,3];case 3:return[2]}}))}))},t.fetchMoreGroups=function(){return K(t,void 0,void 0,(function(){var e,t,n,r;return Q(this,(function(o){switch(o.label){case 0:if(!((e=this.state.paging)&&e.total>e.pageIndex*e.pageSize))return[3,4];o.label=1;case 1:return o.trys.push([1,3,,4]),[4,this.makeFetchGroupsRequest({p:e.pageIndex+1})];case 2:return t=o.sent(),n=t.groups,r=t.paging,this.mounted&&this.setState((function(e){var t=e.groups;return{groups:V(void 0===t?[]:t,n),loading:!1,paging:r}})),[3,4];case 3:return o.sent(),this.stopLoading(),[3,4];case 4:return[2]}}))}))},t.search=function(e){t.fetchGroups({q:e}),t.setState({query:e})},t.refresh=function(){return K(t,void 0,void 0,(function(){var e,t,n,r;return Q(this,(function(o){switch(o.label){case 0:return e=this.state,t=e.paging,n=e.query,[4,this.fetchGroups({q:n})];case 1:if(o.sent(),!(t&&t.pageIndex>1))return[3,5];r=1,o.label=2;case 2:return r<t.pageIndex?[4,this.fetchMoreGroups()]:[3,5];case 3:o.sent(),o.label=4;case 4:return r++,[3,2];case 5:return[2]}}))}))},t.closeDeleteForm=function(){t.setState({groupToBeDeleted:void 0})},t.closeEditForm=function(){t.setState({editedGroup:void 0})},t.openDeleteForm=function(e){t.setState({groupToBeDeleted:e})},t.openEditForm=function(e){t.setState({editedGroup:e})},t.handleCreate=function(e){return K(t,void 0,void 0,(function(){return Q(this,(function(t){switch(t.label){case 0:return[4,Object(p.b)(H({},e))];case 1:return t.sent(),[4,this.refresh()];case 2:return t.sent(),[2]}}))}))},t.handleDelete=function(){return K(t,void 0,void 0,(function(){var e;return Q(this,(function(t){switch(t.label){case 0:return(e=this.state.groupToBeDeleted)?[4,Object(p.c)({name:e.name})]:[2];case 1:return t.sent(),[4,this.refresh()];case 2:return t.sent(),this.mounted&&this.setState({groupToBeDeleted:void 0}),[2]}}))}))},t.handleEdit=function(e){var n=e.name,r=e.description;return K(t,void 0,void 0,(function(){var e,t;return Q(this,(function(o){switch(o.label){case 0:return(e=this.state.editedGroup)?(t=H({description:r,id:e.id},Object(l.omitNil)({name:n!==e.name?n:void 0})),[4,Object(p.g)(t)]):[2];case 1:return o.sent(),this.mounted&&this.setState((function(n){var r=n.groups;return{editedGroup:void 0,groups:(void 0===r?[]:r).map((function(n){return n.name===e.name?H(H({},n),t):n}))}})),[2]}}))}))},t}return J(t,e),t.prototype.componentDidMount=function(){this.mounted=!0,this.fetchGroups()},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this.state,t=e.editedGroup,n=e.groupToBeDeleted,a=e.groups,i=e.loading,l=e.paging,p=e.query,m="anyone".includes(p.toLowerCase());return r.createElement(r.Fragment,null,r.createElement(d.a,{suggestions:"user_groups"}),r.createElement(o.a,{defer:!1,title:Object(u.translate)("user_groups.page")}),r.createElement("div",{className:"page page-limited",id:"groups-page"},r.createElement(j,{onCreate:this.handleCreate}),r.createElement(c.a,{className:"big-spacer-bottom",id:"groups-search",minLength:2,onChange:this.search,placeholder:Object(u.translate)("search.search_by_name"),value:p}),void 0!==a&&r.createElement(W,{groups:a,onDelete:this.openDeleteForm,onEdit:this.openEditForm,onEditMembers:this.refresh,showAnyone:m}),void 0!==a&&void 0!==l&&r.createElement("div",{id:"groups-list-footer"},r.createElement(s.a,{count:m?a.length+1:a.length,loading:i,loadMore:this.fetchMoreGroups,ready:!i,total:m?l.total+1:l.total})),n&&r.createElement(E,{group:n,onClose:this.closeDeleteForm,onSubmit:this.handleDelete}),t&&r.createElement(O,{confirmButtonText:Object(u.translate)("update_verb"),group:t,header:Object(u.translate)("groups.update_group"),onClose:this.closeEditForm,onSubmit:this.handleEdit})))},t}(r.PureComponent);t.default=X},684:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var r,o=n(13),a=n(716),s=(r=function(e,t){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}r(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)});function i(e){var t=e.suggestions;return o.createElement(a.a.Consumer,null,(function(e){var n=e.addSuggestions,r=e.removeSuggestions;return o.createElement(c,{addSuggestions:n,removeSuggestions:r,suggestions:t})}))}var c=function(e){function t(){return null!==e&&e.apply(this,arguments)||this}return s(t,e),t.prototype.componentDidMount=function(){this.props.addSuggestions(this.props.suggestions)},t.prototype.componentDidUpdate=function(e){e.suggestions!==this.props.suggestions&&(this.props.removeSuggestions(this.props.suggestions),this.props.addSuggestions(e.suggestions))},t.prototype.componentWillUnmount=function(){this.props.removeSuggestions(this.props.suggestions)},t.prototype.render=function(){return null},t}(o.PureComponent)}}]);
//# sourceMappingURL=346.1601658702741.chunk.js.map