package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priorty;
    private String descriptions;
    private boolean catalogStatus;

    Scanner scanner = new Scanner(System.in);

    public Catalog() {
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriorty() {
        return priorty;
    }

    public void setPriorty(int priorty) {
        this.priorty = priorty;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public Catalog(int catalogId, String catalogName, int priorty, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priorty = priorty;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData(List<Catalog> listCatalogs) {
        System.out.println("Nhập tên danh mục sản phẩm: ");
        catalogName = scanner.nextLine();
        System.out.println("Nhập độ ưu tiên: ");
        priorty = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả danh mục: ");
        descriptions = scanner.nextLine();
        System.out.println("Nhập trạng thái danh mục(true/false): ");
        catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("------------------------------------------");
        System.out.println("Mã danh mục: " + catalogId);
        System.out.println("Tên danh mục: " + catalogName);
        System.out.println("------------------------------------------");
    }
}
