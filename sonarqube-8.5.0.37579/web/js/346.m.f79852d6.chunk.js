(window.webpackJsonp=window.webpackJsonp||[]).push([[346],{1860:function(e,t,s){"use strict";s.r(t),s.d(t,"default",(function(){return z}));var n=s(2),a=s(332),r=s(347),o=s.n(r),i=s(350),l=s.n(i),c=s(31),u=s(9),d=s(792),m=s(335),p=s(312),h=s(333),g=s.n(h),b=s(317),E=s.n(b);function f({group:e,onClose:t,onSubmit:s}){const a=Object(c.translate)("groups.delete_group");return n.createElement(g.a,{header:a,onClose:t,onSubmit:s},({onCloseClick:t,onFormSubmit:s,submitting:r})=>n.createElement("form",{onSubmit:s},n.createElement("header",{className:"modal-head"},n.createElement("h2",null,a)),n.createElement("div",{className:"modal-body"},Object(c.translateWithParameters)("groups.delete_group.confirmation",e.name)),n.createElement("footer",{className:"modal-foot"},n.createElement(E.a,{className:"spacer-right",loading:r}),n.createElement(p.SubmitButton,{className:"button-red",disabled:r},Object(c.translate)("delete")),n.createElement(p.ResetButtonLink,{disabled:r,onClick:t},Object(c.translate)("cancel")))))}class O extends n.PureComponent{constructor(e){super(e),this.handleSubmit=()=>this.props.onSubmit({description:this.state.description,name:this.state.name}).then(this.props.onClose),this.handleDescriptionChange=e=>{this.setState({description:e.currentTarget.value})},this.handleNameChange=e=>{this.setState({name:e.currentTarget.value})},this.state={description:e.group&&e.group.description||"",name:e.group&&e.group.name||""}}render(){return n.createElement(g.a,{header:this.props.header,onClose:this.props.onClose,onSubmit:this.handleSubmit,size:"small"},({onCloseClick:e,onFormSubmit:t,submitting:s})=>n.createElement("form",{onSubmit:t},n.createElement("header",{className:"modal-head"},n.createElement("h2",null,this.props.header)),n.createElement("div",{className:"modal-body"},n.createElement("div",{className:"modal-field"},n.createElement("label",{htmlFor:"create-group-name"},Object(c.translate)("name"),n.createElement("em",{className:"mandatory"},"*")),n.createElement("input",{autoFocus:!0,id:"create-group-name",maxLength:255,name:"name",onChange:this.handleNameChange,required:!0,size:50,type:"text",value:this.state.name})),n.createElement("div",{className:"modal-field"},n.createElement("label",{htmlFor:"create-group-description"},Object(c.translate)("description")),n.createElement("textarea",{id:"create-group-description",name:"description",onChange:this.handleDescriptionChange,value:this.state.description}))),n.createElement("footer",{className:"modal-foot"},n.createElement(E.a,{className:"spacer-right",loading:s}),n.createElement(p.SubmitButton,{disabled:s},this.props.confirmButtonText),n.createElement(p.ResetButtonLink,{onClick:e},Object(c.translate)("cancel")))))}}class S extends n.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={createModal:!1},this.handleCreateClick=()=>{this.setState({createModal:!0})},this.handleClose=()=>{this.mounted&&this.setState({createModal:!1})},this.handleSubmit=e=>this.props.onCreate(e)}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){return n.createElement(n.Fragment,null,n.createElement("header",{className:"page-header",id:"groups-header"},n.createElement("h1",{className:"page-title"},Object(c.translate)("user_groups.page")),n.createElement("div",{className:"page-actions"},n.createElement(p.Button,{id:"groups-create",onClick:this.handleCreateClick},Object(c.translate)("groups.create_group"))),n.createElement("p",{className:"page-description"},Object(c.translate)("user_groups.page.description"))),this.state.createModal&&n.createElement(O,{confirmButtonText:Object(c.translate)("create"),header:Object(c.translate)("groups.create_group"),onClose:this.handleClose,onSubmit:this.handleSubmit}))}}var j=s(328),C=s.n(j),N=s(383),y=s.n(N),v=s(599),w=s.n(v),D=s(360),k=s.n(D),_=s(506),x=s.n(_),F=s(330),M=s.n(F),P=s(508),T=s.n(P);class U extends n.PureComponent{constructor(e){super(e),this.mounted=!1,this.fetchUsers=e=>Object(d.d)({name:this.props.group.name,p:e.page,ps:e.pageSize,q:""!==e.query?e.query:void 0,selected:e.filter}).then(t=>{this.mounted&&this.setState(s=>{const n=null!=e.page&&e.page>1,a=n?[...s.users,...t.users]:t.users,r=t.users.filter(e=>e.selected).map(e=>e.login),o=n?[...s.selectedUsers,...r]:r;return{needToReload:!1,lastSearchParams:e,loading:!1,users:a,usersTotalCount:t.total,selectedUsers:o}})}),this.handleSelect=e=>Object(d.a)({name:this.props.group.name,login:e}).then(()=>{this.mounted&&this.setState(t=>({needToReload:!0,selectedUsers:[...t.selectedUsers,e]}))}),this.handleUnselect=e=>Object(d.e)({name:this.props.group.name,login:e}).then(()=>{this.mounted&&this.setState(t=>({needToReload:!0,selectedUsers:k()(t.selectedUsers,e)}))}),this.renderElement=e=>{const t=x()(this.state.users,{login:e});return n.createElement("div",{className:"select-list-list-item"},void 0===t?e:n.createElement(n.Fragment,null,t.name,n.createElement("br",null),n.createElement("span",{className:"note"},t.login)))},this.state={needToReload:!1,users:[],selectedUsers:[]}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const e=Object(c.translate)("users.update");return n.createElement(M.a,{contentLabel:e,onRequestClose:this.props.onClose},n.createElement("header",{className:"modal-head"},n.createElement("h2",null,e)),n.createElement("div",{className:"modal-body modal-container"},n.createElement(T.a,{elements:this.state.users.map(e=>e.login),elementsTotalCount:this.state.usersTotalCount,needToReload:this.state.needToReload&&this.state.lastSearchParams&&this.state.lastSearchParams.filter!==P.SelectListFilter.All,onSearch:this.fetchUsers,onSelect:this.handleSelect,onUnselect:this.handleUnselect,renderElement:this.renderElement,selectedElements:this.state.selectedUsers,withPaging:!0})),n.createElement("footer",{className:"modal-foot"},n.createElement(p.ResetButtonLink,{onClick:this.props.onClose},Object(c.translate)("Done"))))}}class q extends n.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={modal:!1},this.handleMembersClick=()=>{this.setState({modal:!0})},this.handleModalClose=()=>{this.mounted&&(this.setState({modal:!1}),this.props.onEdit())}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){return n.createElement(n.Fragment,null,n.createElement(p.ButtonIcon,{"aria-label":Object(c.translate)("groups.users.edit"),className:"button-small",onClick:this.handleMembersClick,title:Object(c.translate)("groups.users.edit")},n.createElement(w.a,null)),this.state.modal&&n.createElement(U,{group:this.props.group,onClose:this.handleModalClose}))}}function B(e){const{group:t}=e;return n.createElement("tr",{"data-id":t.name},n.createElement("td",{className:"width-20"},n.createElement("strong",{className:"js-group-name"},t.name),t.default&&n.createElement("span",{className:"little-spacer-left"},"(",Object(c.translate)("default"),")")),n.createElement("td",{className:"thin text-middle text-right little-padded-right"},t.membersCount),n.createElement("td",{className:"little-padded-left"},!t.default&&n.createElement(q,{group:t,onEdit:e.onEditMembers})),n.createElement("td",{className:"width-40"},n.createElement("span",{className:"js-group-description"},t.description)),n.createElement("td",{className:"thin nowrap text-right"},!t.default&&n.createElement(y.a,null,n.createElement(N.ActionsDropdownItem,{className:"js-group-update",onClick:()=>e.onEdit(t)},Object(c.translate)("update_details")),n.createElement(N.ActionsDropdownDivider,null),n.createElement(N.ActionsDropdownItem,{className:"js-group-delete",destructive:!0,onClick:()=>e.onDelete(t)},Object(c.translate)("delete")))))}function G(e){return n.createElement("div",{className:"boxed-group boxed-group-inner"},n.createElement("table",{className:"data zebra zebra-hover",id:"groups-list"},n.createElement("thead",null,n.createElement("tr",null,n.createElement("th",null),n.createElement("th",{className:"nowrap width-10",colSpan:2},Object(c.translate)("members")),n.createElement("th",{className:"nowrap"},Object(c.translate)("description")),n.createElement("th",null))),n.createElement("tbody",null,e.showAnyone&&n.createElement("tr",{className:"js-anyone",key:"anyone"},n.createElement("td",{className:"width-20"},n.createElement("strong",{className:"js-group-name"},Object(c.translate)("groups.anyone"))),n.createElement("td",{className:"width-10",colSpan:2}),n.createElement("td",{className:"width-40",colSpan:2},n.createElement("span",{className:"js-group-description"},Object(c.translate)("user_groups.anyone.description")))),C()(e.groups,e=>e.name.toLowerCase()).map(t=>n.createElement(B,{group:t,key:t.name,onDelete:e.onDelete,onEdit:e.onEdit,onEditMembers:e.onEditMembers})))))}function R(e,t){var s=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),s.push.apply(s,n)}return s}function L(e){for(var t=1;t<arguments.length;t++){var s=null!=arguments[t]?arguments[t]:{};t%2?R(Object(s),!0).forEach((function(t){I(e,t,s[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(s)):R(Object(s)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(s,t))}))}return e}function I(e,t,s){return t in e?Object.defineProperty(e,t,{value:s,enumerable:!0,configurable:!0,writable:!0}):e[t]=s,e}class z extends n.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!0,query:""},this.makeFetchGroupsRequest=e=>(this.setState({loading:!0}),Object(d.f)(L({q:this.state.query},e))),this.stopLoading=()=>{this.mounted&&this.setState({loading:!1})},this.fetchGroups=async e=>{try{const{groups:t,paging:s}=await this.makeFetchGroupsRequest(e);this.mounted&&this.setState({groups:t,loading:!1,paging:s})}catch(e){this.stopLoading()}},this.fetchMoreGroups=async()=>{const{paging:e}=this.state;if(e&&e.total>e.pageIndex*e.pageSize)try{const{groups:t,paging:s}=await this.makeFetchGroupsRequest({p:e.pageIndex+1});this.mounted&&this.setState(({groups:e=[]})=>({groups:[...e,...t],loading:!1,paging:s}))}catch(e){this.stopLoading()}},this.search=e=>{this.fetchGroups({q:e}),this.setState({query:e})},this.refresh=async()=>{const{paging:e,query:t}=this.state;if(await this.fetchGroups({q:t}),e&&e.pageIndex>1)for(let t=1;t<e.pageIndex;t++)await this.fetchMoreGroups()},this.closeDeleteForm=()=>{this.setState({groupToBeDeleted:void 0})},this.closeEditForm=()=>{this.setState({editedGroup:void 0})},this.openDeleteForm=e=>{this.setState({groupToBeDeleted:e})},this.openEditForm=e=>{this.setState({editedGroup:e})},this.handleCreate=async e=>{await Object(d.b)(L({},e)),await this.refresh()},this.handleDelete=async()=>{const{groupToBeDeleted:e}=this.state;e&&(await Object(d.c)({name:e.name}),await this.refresh(),this.mounted&&this.setState({groupToBeDeleted:void 0}))},this.handleEdit=async({name:e,description:t})=>{const{editedGroup:s}=this.state;if(!s)return;const n=L({description:t,id:s.id},Object(u.omitNil)({name:e!==s.name?e:void 0}));await Object(d.g)(n),this.mounted&&this.setState(({groups:e=[]})=>({editedGroup:void 0,groups:e.map(e=>e.name===s.name?L({},e,{},n):e)}))}}componentDidMount(){this.mounted=!0,this.fetchGroups()}componentWillUnmount(){this.mounted=!1}render(){const{editedGroup:e,groupToBeDeleted:t,groups:s,loading:r,paging:i,query:u}=this.state,d="anyone".includes(u.toLowerCase());return n.createElement(n.Fragment,null,n.createElement(m.a,{suggestions:"user_groups"}),n.createElement(a.a,{defer:!1,title:Object(c.translate)("user_groups.page")}),n.createElement("div",{className:"page page-limited",id:"groups-page"},n.createElement(S,{onCreate:this.handleCreate}),n.createElement(l.a,{className:"big-spacer-bottom",id:"groups-search",minLength:2,onChange:this.search,placeholder:Object(c.translate)("search.search_by_name"),value:u}),void 0!==s&&n.createElement(G,{groups:s,onDelete:this.openDeleteForm,onEdit:this.openEditForm,onEditMembers:this.refresh,showAnyone:d}),void 0!==s&&void 0!==i&&n.createElement("div",{id:"groups-list-footer"},n.createElement(o.a,{count:d?s.length+1:s.length,loading:r,loadMore:this.fetchMoreGroups,ready:!r,total:d?i.total+1:i.total})),t&&n.createElement(f,{group:t,onClose:this.closeDeleteForm,onSubmit:this.handleDelete}),e&&n.createElement(O,{confirmButtonText:Object(c.translate)("update_verb"),group:e,header:Object(c.translate)("groups.update_group"),onClose:this.closeEditForm,onSubmit:this.handleEdit})))}}},335:function(e,t,s){"use strict";s.d(t,"a",(function(){return r}));var n=s(2),a=s(368);function r({suggestions:e}){return n.createElement(a.a.Consumer,null,({addSuggestions:t,removeSuggestions:s})=>n.createElement(o,{addSuggestions:t,removeSuggestions:s,suggestions:e}))}class o extends n.PureComponent{componentDidMount(){this.props.addSuggestions(this.props.suggestions)}componentDidUpdate(e){e.suggestions!==this.props.suggestions&&(this.props.removeSuggestions(this.props.suggestions),this.props.addSuggestions(e.suggestions))}componentWillUnmount(){this.props.removeSuggestions(this.props.suggestions)}render(){return null}}},792:function(e,t,s){"use strict";s.d(t,"f",(function(){return r})),s.d(t,"d",(function(){return o})),s.d(t,"a",(function(){return i})),s.d(t,"e",(function(){return l})),s.d(t,"b",(function(){return c})),s.d(t,"g",(function(){return u})),s.d(t,"c",(function(){return d}));var n=s(9),a=s(326);function r(e){return Object(n.getJSON)("/api/user_groups/search",e).catch(a.a)}function o(e){return Object(n.getJSON)("/api/user_groups/users",e).catch(a.a)}function i(e){return Object(n.post)("/api/user_groups/add_user",e).catch(a.a)}function l(e){return Object(n.post)("/api/user_groups/remove_user",e).catch(a.a)}function c(e){return Object(n.postJSON)("/api/user_groups/create",e).then(e=>e.group,a.a)}function u(e){return Object(n.post)("/api/user_groups/update",e).catch(a.a)}function d(e){return Object(n.post)("/api/user_groups/delete",e).catch(a.a)}}}]);
//# sourceMappingURL=346.m.f79852d6.chunk.js.map