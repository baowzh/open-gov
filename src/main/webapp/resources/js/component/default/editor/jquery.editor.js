var asiainfoText = $.widget("ui.asiainfoEditor",jQuery.ui.formComponent,{
					version : "1.0.0-beta.1",
					defaultElement : "<div>",
					delay : 300,
					options : {
						/**
						 * 选择器
						 */
						id : '',

						elmentid : 'elmentid',

						fieldname : '',
						/**
						 * 监听字段的其他字段列表
						 */
						listeners : [],
						/**
						 * 过滤字段
						 */
						filterfields : [],
						/**
						 * 初始化过滤参数和值列表
						 */
						filtervals : [],
						/**
						 * 默认值
						 */
						defaultvalue : '',

						required : false,
						/**
						 * 由系统统一验证则设置为false
						 */
						valid : false,
						cssPath : window.contextroot+'/resources/js/kindeditor/plugins/code/prettify.css',
						uploadJson : window.contextroot+'/file/upload.jhtml',
						fileManagerJson : window.contextroot+'/file/manager.jhtml',
						allowFileManager : true,
						afterBlur : function() {
							this.sync();
						},
						readonly : false,
						tooltipmess : '',
						messcontainer : '.errormessage',
						height:400
					},
					/**
					 * 构造方法
					 */
					_create : function() {
						if (this.options.required) {
							this.element.attr({
								required : 'required'
							});
						}
						this.element
								.attr({
									'data-parsley-errors-container' : this.options.messcontainer
								});
						if (this.options.tooltipmess != '') {
							this.element
									.attr({
										'data-parsley-error-message' : this.options.tooltipmess
									});
						}
						if (this.options.fieldname != '') {
							this.element.attr('name', this.options.fieldname);
						}
						KindEditor.v_options = this.options;
						KindEditor.ready(function(K) {
							var options = KindEditor.v_options;
							var editor = K.create(options.id, options);
							var defaultvalue = options.defaultvalue;
							if (defaultvalue != "") {
								editor.html(defaultvalue);
							}
							var readonly = options.readonly;
							if (readonly) {
								editor.readonly();
							}
						});
						// 给组件添加监听方法
						this._on($(this.element), {
							"change" : function(event) {
								this._fireListener();
							}
						});

					},
					setValue : function(context) {
					},
					getValue : function() {
						return this.element.val();
					},
					/**
					 * 由别的组件调用刷新树组件
					 */
					refreshdata : function() {
					}
				});
