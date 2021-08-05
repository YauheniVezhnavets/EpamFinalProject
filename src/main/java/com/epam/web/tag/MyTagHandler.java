package com.epam.web.tag;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport {

    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();

        try {
            out.print(Calendar.getInstance().getTime());
        } catch (Exception e) {
            throw new JspException(e.getMessage(), e);
        }
        return SKIP_BODY;
    }
}
