package com.zasa.fuellyvendor.Request;

import com.google.gson.annotations.SerializedName;
import com.zasa.fuellyvendor.Response.Product_Wise_Request_Model;

import java.util.ArrayList;

public class Product_Wise_Request {
    @SerializedName("Status")
    private int status;

    ArrayList<Product_Wise_Request_Model> Product_List = new ArrayList<>();
    Product_Wise_Request_Model productTypeWiseModel ;

    public Product_Wise_Request(int status, ArrayList<Product_Wise_Request_Model> product_List, Product_Wise_Request_Model productTypeWiseModel) {
        this.status = status;
        Product_List = product_List;
        this.productTypeWiseModel = productTypeWiseModel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Product_Wise_Request_Model> getProduct_List() {
        return Product_List;
    }

    public void setProduct_List(ArrayList<Product_Wise_Request_Model> product_List) {
        Product_List = product_List;
    }

    public Product_Wise_Request_Model getProductTypeWiseModel() {
        return productTypeWiseModel;
    }

    public void setProductTypeWiseModel(Product_Wise_Request_Model productTypeWiseModel) {
        this.productTypeWiseModel = productTypeWiseModel;
    }
}
