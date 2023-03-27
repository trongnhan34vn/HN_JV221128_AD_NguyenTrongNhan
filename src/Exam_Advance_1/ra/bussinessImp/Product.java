package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop, Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    Scanner scanner = new Scanner(System.in);

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(List<Catalog> listCatalogs) {
        System.out.println("Nhập tên sản phẩm: ");
        productName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sản phẩm: ");
        title = scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm: ");
        descriptions = scanner.nextLine();
        System.out.println("Nhập giá nhập sản phẩm: ");
        importPrice = Float.parseFloat(scanner.nextLine());
        exportPrice = importPrice * RATE;
        System.out.println("Danh sách danh mục sản phẩm: ");
        for (Catalog catalog : listCatalogs) {
            catalog.displayData();
        }
        while (true) {
            System.out.println("Lựa chọn danh mục sản phẩm theo Id: ");
            int choiceCatalogId = Integer.parseInt(scanner.nextLine());
            boolean isExist = false;
            Catalog choiceCatalog = new Catalog();
            for (Catalog catalog : listCatalogs) {
                if (choiceCatalogId == catalog.getCatalogId()) {
                    isExist = true;
                    choiceCatalog = catalog;
                    break;
                }
            }
            if (isExist) {
                catalog = choiceCatalog;
                break;
            } else {
                System.out.println("Không tìm thấy danh mục sản phẩm! Vui lòng nhập lại!");
            }
        }
        System.out.println("Nhập trạng thái sản phẩm: ");
        productStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("-------------------------------------------");
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Tên danh mục sản phẩm: " + catalog.getCatalogName());
        System.out.println("Giá bán sản phẩm: " + exportPrice);
        System.out.println("Trạng thái: " + ((productStatus) ? "Còn hàng" : "Hết hàng"));
        System.out.println("-------------------------------------------");
    }

    @Override
    public int compareTo(Product o) {
        return (int) (exportPrice - o.exportPrice);
    }
}
