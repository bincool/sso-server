<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="includes/top.jsp" />
</div></div>
<script>
    var content=document.getElementById("content");
    content.style.cssText="display: none;";
    var header=document.getElementsByTagName("header")[0];
    header.style.cssText="display: none;";
</script>
<div id="head-box">
    <div>
        <div class="head">
            <div class="left">LOGO</div>
            <div class="right">
                <i class="iconfont icon-tel2"></i>
                <span><spring:message code="screen.welcome.tel" />400-100-1000</span>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div id="content_gsl">
    <div>
        <div id="login-box-gsl">
            <p class="title"><spring:message code="screen.welcome.login.title"/></p>
            <div id="cookiesDisabled" class="errors" style="display:none;">
                <h2><spring:message code="screen.cookies.disabled.title" /></h2>
                <p><spring:message code="screen.cookies.disabled.message" /></p>
            </div>
            <%--<div class="box" id="login" >--%>
            <div id="login-gsl">
                <form:form method="post" id="fm1" commandName="${commandName}" htmlEscape="true">

                    <form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false" />

                    <%--<h2><spring:message code="screen.welcome.instructions" /></h2>--%>

                    <section class="row ipt-row">
                        <i class="iconfont icon-user"></i>
                        <label style="display: none" for="username"><spring:message code="screen.welcome.label.netid" /></label>
                        <c:choose>
                            <c:when test="${not empty sessionScope.openIdLocalId}">
                                <strong><c:out value="${sessionScope.openIdLocalId}" /></strong>
                                <input type="hidden" id="username" name="username" value="<c:out value="${sessionScope.openIdLocalId}" />" />
                            </c:when>
                            <c:otherwise>
                                <spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
                                <form:input cssClass="required" cssErrorClass="error" placeholder="请输入手机号码／用户名" id="username" size="25" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="off" htmlEscape="true" />
                            </c:otherwise>
                        </c:choose>
                    </section>

                    <section class="row ipt-row">
                        <i class="iconfont icon-pwd"></i>
                        <label  style="display: none" for="password"><spring:message code="screen.welcome.label.password" /></label>
                            <%--
                            NOTE: Certain browsers will offer the option of caching passwords for a user.  There is a non-standard attribute,
                            "autocomplete" that when set to "off" will tell certain browsers not to prompt to cache credentials.  For more
                            information, see the following web page:
                            http://www.technofundo.com/tech/web/ie_autocomplete.html
                            --%>
                        <spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
                        <form:password cssClass="required" cssErrorClass="error" placeholder="请输入密码" id="password" size="25" tabindex="2" path="password"  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
                        <%--<span id="capslock-on" style="display:none;"><p><img src="images/warning.png" valign="top"> <spring:message code="screen.capslock.on" /></p></span>--%>
                    </section>

                    <section class="row safe-row">
                        <div class="dv">
                            <i class="iconfont icon-safe"></i>
                            <label  style="display: none" for="captcha"><spring:message code="screen.welcome.label.captcha" /></label>
                            <spring:message code="screen.welcome.label.captcha.accesskey" var="captchaAccessKey" />
                            <form:input cssClass="required" cssErrorClass="error" placeholder="请输入验证码" id="captcha" size="16" tabindex="2" path="captcha"  accesskey="${captchaAccessKey}" htmlEscape="true" autocomplete="off" style="width: 120px"/>
                        </div>
                        <div class="imgDiv">
                            <img src="/ctl/captcha.png" style="vertical-align:middle">
                        </div>
                        <%--<span id="capslock-on" style="display:none;"><p><img src="images/warning.png" valign="top"> <spring:message code="screen.capslock.on" /></p></span>--%>
                    </section>

                    <!--
                    <section class="row check">
                    <p>
                    <input id="warn" name="warn" value="true" tabindex="3" accesskey="<spring:message code="screen.welcome.label.warn.accesskey" />" type="checkbox" />
                    <label for="warn"><spring:message code="screen.welcome.label.warn" /></label>
                    <br/>
                    <input id="publicWorkstation" name="publicWorkstation" value="false" tabindex="4" type="checkbox" />
                    <label for="publicWorkstation"><spring:message code="screen.welcome.label.publicstation" /></label>
                    <br/>
                    <input type="checkbox" name="rememberMe" id="rememberMe" value="true" tabindex="5"  />
                    <label for="rememberMe"><spring:message code="screen.rememberme.checkbox.title" /></label>
                    </p>
                    </section>
                    -->
                    <section class="row a-row">
                        <%--<a href=""><spring:message code="screen.welcome.login.forget" /></a>--%>
                    </section>
                    <section class="row btn-row">

                        <input type="hidden" name="execution" value="${flowExecutionKey}" />
                        <input type="hidden" name="_eventId" value="submit" />

                        <input class="btn-submit" name="submit" accesskey="l" value="<spring:message code="screen.welcome.button.login" />" tabindex="6" type="submit" style="border: none;"/>
                        <%--<input class="btn-reset" name="reset" accesskey="c" value="<spring:message code="screen.welcome.button.clear" />" tabindex="7" type="reset" />--%>
                    </section>
                </form:form>
            </div>
        </div>
    </div>


<jsp:directive.include file="includes/bottom.jsp" />
