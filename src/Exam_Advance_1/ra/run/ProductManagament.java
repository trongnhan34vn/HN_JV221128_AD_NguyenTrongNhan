package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagament {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Product> listProducts = new ArrayList<>();
        List<Catalog> listCatalogs = new ArrayList<>();
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục\n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm\n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)\n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm\n" +
                    "5. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    Thêm mới n catalogs
                    createCatalogs(listCatalogs);
                    break;
                case 2:
//                    Thêm mới n sản phẩm
                    createProducts(listCatalogs,listProducts);
                    break;
                case 3:
//                    Sắp xếp danh sách sản phẩm theo giá bán
                    sortProductByPrice(listProducts);
                    break;
                case 4:
//                    Tìm kiếm sản phẩm theo tên catalog
                    searchProductByCatalogName(listProducts,listCatalogs);
                    break;
                case 5:
//                    Kết thúc
                    System.out.println("Kết thúc!");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void createCatalogs(List<Catalog> listCatalogs) {
        System.out.println("Nhập số danh mục sản phẩm: ");
        int mountCatalogs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < mountCatalogs; i++) {
            System.out.println("Nhập thông tin danh mục sản phẩm thứ " + (i + 1));
            Catalog newCatalog = new Catalog();
            if (listCatalogs.isEmpty()) {
                newCatalog.setCatalogId(1);
            } else {
                newCatalog.setCatalogId(listCatalogs.get(listCatalogs.size() - 1).getCatalogId() + 1);
            }
            newCatalog.inputData(listCatalogs);
            listCatalogs.add(newCatalog);
        }
        System.out.println("Thêm mới thành công " + mountCatalogs + " danh mục sản phẩm!");
        displayCatalog(listCatalogs);
    }

    public static void createProducts(List<Catalog> listCatalogs, List<Product> listProducts) {
        System.out.println("Nhập số sản phẩm: ");
        int mountProducts = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < mountProducts; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1));
            Product newProduct = new Product();
            if (listProducts.isEmpty()) {
                newProduct.setProductId(1);
            } else {
                newProduct.setProductId(listProducts.get(listProducts.size() - 1).getProductId() + 1);
            }
            newProduct.inputData(listCatalogs);
            listProducts.add(newProduct);
        }
        System.out.println("Thêm mới thành công " + mountProducts + " sản phẩm!");
        displayProduct(listProducts);
    }

    public static void sortProductByPrice(List<Product> listProducts) {
        List<Product> sortList = new ArrayList<>(listProducts);
        Collections.sort(sortList);
        System.out.println("Sắp xếp thành công!");
        displayProduct(sortList);
    }

    public static void searchProductByCatalogName(List<Product> listProducts, List<Catalog> listCatalogs) {
        displayCatalog(listCatalogs);
        while (true) {
            System.out.println("Nhập vào tên danh mục sản phẩm: ");
            String searchCatName = scanner.nextLine();
            boolean isExist = false;
            for (Catalog catalog:listCatalogs) {
                if(catalog.getCatalogName().toLowerCase().contains(searchCatName)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                List<Product> searchList = new ArrayList<>(listProducts);
                searchList.removeIf(product -> !product.getCatalog().getCatalogName().toLowerCase().contains(searchCatName));
                displayProduct(searchList);
                return;
            } else {
                System.out.println("Không tìm thấy sản phẩm nào! Vui lòng thử lại!");
            }
        }
    }

    public static void displayProduct(List<Product> listProducts) {
        System.out.println("Danh sách sản phẩm: ");
        for (Product product : listProducts) {
            product.displayData();
        }
    }

    public static void displayCatalog(List<Catalog> listCatalogs) {
        System.out.println("Danh sách danh mục sản phẩm: ");
        for (Catalog catalog : listCatalogs) {
            catalog.displayData();
        }
    }
}
