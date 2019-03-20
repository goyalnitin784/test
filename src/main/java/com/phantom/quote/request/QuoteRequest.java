package com.phantom.quote.request;

import com.phantom.request.MapBasedRequest;

import javax.servlet.http.HttpServletRequest;


public class QuoteRequest extends MapBasedRequest {
    private static final long serialVersionUID = -6642957764091515832L;

    private String ssoToken;
    private String location;
    private String product;
    private String quantity;
    private String comments;

    public QuoteRequest(HttpServletRequest request) {
        super(request);
        postConstruct();
    }

    private void postConstruct() {
        this.location = requestParameters.get("location");
        this.product = requestParameters.get("product");
        this.quantity = requestParameters.get("quantity");
        this.comments = requestParameters.get("comments");
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSsoToken() {
        return ssoToken;
    }

    public void setSsoToken(String ssoToken) {
        this.ssoToken = ssoToken;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

