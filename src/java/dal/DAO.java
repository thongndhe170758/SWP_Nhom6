
package dal;


import entity.Book_Cart;
import entity.Category;
import entity.CategoryGenreInfo;
import entity.bookGerne;
import entity.bookImage;
import entity.book_detail;
import entity.book_show;
import entity.merchandise;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author taote
 */
public class DAO extends MyDAO {

    public List<merchandise> getMerch() {
        List<merchandise> t = new ArrayList<>();
        xSql = "select * from merchandise";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xRollno, xName;
            merchandise x;
            while (rs.next()) {
                xRollno = rs.getString("idMerchandise");
                xName = rs.getString("merName");
                x = new merchandise(xRollno, xName);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Category> getCategoryByID(int id) {
        List<Category> categories = new ArrayList<>();
        String xSql = "SELECT * FROM category WHERE merchandiseID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCate = rs.getInt("idCategory");
                String catName = rs.getString("catName");
                int idMerch = rs.getInt("merchandiseID");
                Category category = new Category(idCate, catName, idMerch);
                categories.add(category);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    public List<Category> getCategory() {
        List<Category> categories = new ArrayList<>();
        String xSql = "SELECT * FROM category";

        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idCate = rs.getInt("idCategory");
                String catName = rs.getString("catName");
                int idMerch = rs.getInt("merchandiseID");
                Category category = new Category(idCate, catName, idMerch);
                categories.add(category);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
    public ArrayList<book_detail> getBookDetails() {
    ArrayList<book_detail> bookList = new ArrayList<>();
    String sql = "SELECT * FROM bookdetailed";
    try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("book_id");
            String name = rs.getString("product_name");
            String supplier = rs.getString("supplier");
            String publisher = rs.getString("publisher");
            String cover_form = rs.getString("cover_form");
            String price = rs.getString("price");
            int quantity = rs.getInt("quantity");
            String author = rs.getString("author");
            String year_publish = rs.getString("year_publish");
            String language = rs.getString("language");
            String weight = rs.getString("weight");
            String package_size = rs.getString("packaging_size");
            String num_page = rs.getString("num_pages");
            String description = rs.getString("description");
            String image = rs.getString("image");
            int categoryID=rs.getInt("categoryID");
            int gerne_id=rs.getInt("gerne_id");
           

            book_detail book = new book_detail(id, name, supplier, publisher, cover_form, price, quantity, author, year_publish, language, weight, package_size, num_page, description, image, categoryID, gerne_id);
            bookList.add(book);
        }
        rs.close();
        ps.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return bookList;
}


    public List<book_show> getBooks() {
        List<book_show> bookList = new ArrayList<>();
        String sql = "SELECT * FROM bookdetailed";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("book_id");
                String name = rs.getString("product_name");
                String price = rs.getString("price");
                String image = rs.getString("image");

                book_show book = new book_show(id, name, price, image);
                bookList.add(book);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public List<bookGerne> getBookGern() {
        List<bookGerne> bookGenreList = new ArrayList<>();
        String sql = "SELECT idbook_gerne, bookGerne FROM book_gerne";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idbook_gerne");
                String name = resultSet.getString("bookGerne");

                bookGerne bookGenre = new bookGerne(id, name);
                bookGenreList.add(bookGenre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and result set
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return bookGenreList;
    }

    public int GetNumberPage() {
        String sql = "SELECT count(*) FROM bookdetailed";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 9;
                if (total % 9 != 0) {
                    countPage++;
                }
                return countPage;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<book_show> getBooksByPage(int i) {
        List<book_show> bookList = new ArrayList<>();
        String sql = "SELECT * FROM bookdetailed "
                + "ORDER BY book_id "
                + "LIMIT 9 OFFSET ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, (i - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
                bookList.add(new book_show(rs.getInt("book_id"), rs.getString("product_name"), rs.getString("price"), rs.getString("image")));
            }
            return bookList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int GetNumberPageMerch(int merchandiseId) {
        String sql = "SELECT count(*) "
                + "FROM bookdetailed b "
                + "JOIN category c ON b.categoryID = c.idCategory "
                + "JOIN merchandise m ON c.merchandiseID = m.idMerchandise "
                + "WHERE m.idMerchandise = ?";
        int countPage = 0;

        try ( PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, merchandiseId);
            try ( ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt(1);
                    countPage = total / 9;
                    if (total % 9 != 0) {
                        countPage++;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countPage;
    }

    

    public List<book_show> getBooksByMerchandiseId2(int merchandiseId, int i) {
        List<book_show> bookList = new ArrayList<>();
        String sql = "SELECT b.* "
                + "FROM bookdetailed b "
                + "JOIN category c ON b.categoryID = c.idCategory "
                + "JOIN merchandise m ON c.merchandiseID = m.idMerchandise "
                + "WHERE m.idMerchandise = ? "
                + "ORDER BY b.book_id "
                + "LIMIT 9 OFFSET ?";

        try ( PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, merchandiseId);
            statement.setInt(2, (i - 1) * 9);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("book_id");
                String name = rs.getString("product_name");
                String price = rs.getString("price");
                String image = rs.getString("image");

                book_show book = new book_show(id, name, price, image);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public int GetNumberPageCategory(int categoryID) {
        String sql = "SELECT count(*) FROM swp_bookstore.bookdetailed b where b.categoryID =?";
        int countPage = 0;

        try ( PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, categoryID);
            try ( ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt(1);
                    countPage = total / 9;
                    if (total % 9 != 0) {
                        countPage++;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countPage;
    }

    public List<book_show> getBooksByCategory(int categoryID, int i) {
        List<book_show> bookList = new ArrayList<>();
        String sql = "SELECT * FROM swp_bookstore.bookdetailed b  WHERE categoryID = ?  ORDER BY b.book_id LIMIT 9 OFFSET ?;";

        try ( PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, categoryID);
            statement.setInt(2, (i - 1) * 9);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("book_id");
                String name = rs.getString("product_name");
                String price = rs.getString("price");
                String image = rs.getString("image");

                book_show book = new book_show(id, name, price, image);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public int GetNumberPageGerne(int genreID) {
        String sql = "SELECT count(*) FROM swp_bookstore.bookdetailed b where b.gerne_id =?";
        int countPage = 0;

        try ( PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, genreID);
            try ( ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt(1);
                    countPage = total / 9;
                    if (total % 9 != 0) {
                        countPage++;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countPage;
    }

    public List<book_show> getBooksByGerne(int genreID, int i) {
        List<book_show> bookList = new ArrayList<>();
        String sql = "SELECT * FROM swp_bookstore.bookdetailed b  WHERE gerne_id = ?  ORDER BY b.book_id LIMIT 9 OFFSET ?;";

        try ( PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, genreID);
            statement.setInt(2, (i - 1) * 9);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("book_id");
                String name = rs.getString("product_name");
                String price = rs.getString("price");
                String image = rs.getString("image");

                book_show book = new book_show(id, name, price, image);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

 

   

    public bookImage getBookImageById(int id) {
        bookImage image = null;
        String query = "SELECT * FROM book_image WHERE image_id = ?";

        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                image = new bookImage();
                image.setId(rs.getInt("image_id"));
                image.setImage1(rs.getString("image1"));
                image.setImage2(rs.getString("image2"));
                image.setImage3(rs.getString("image3"));
                image.setImage4(rs.getString("image4"));
                image.setImage5(rs.getString("image5"));
                image.setImage6(rs.getString("image6"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return image;
    }

   public List<book_show> getBooksByCategoryId(int categoryId) {
    List<book_show> bookList = new ArrayList<>();
    String sql = "SELECT * FROM swp_bookstore.bookdetailed WHERE categoryID = ? ORDER BY book_id LIMIT 4";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
        statement.setInt(1, categoryId);
        try (ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                // Create a Book object from the result set
                book_show book = new book_show();
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("product_name"));
                book.setPrice(rs.getString("price"));
                book.setImage(rs.getString("image"));
                // Add the book to the list
                bookList.add(book);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return bookList;
}
public List<book_show> searchBookByName(String query, int count) {
        List<book_show> books = new ArrayList<>();

        String sql = "SELECT * FROM bookdetailed WHERE product_name LIKE ? ORDER BY book_id LIMIT 9 OFFSET ?;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + query + "%");
            statement.setInt(2, (count - 1) * 9);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                book_show book = new book_show();
                book.setId(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("product_name"));
                book.setPrice(resultSet.getString("price"));
                book.setImage(resultSet.getString("image"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
public int countPageByBookName(String searchName) {
    String sql = "SELECT COUNT(*) FROM bookdetailed WHERE product_name LIKE ? ";
    int countPage = 0;

    try (PreparedStatement statement = con.prepareStatement(sql)) {
        statement.setString(1, "%" + searchName + "%");
        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                int total = rs.getInt(1);
                countPage = total / 9;
                if (total % 9 != 0) {
                    countPage++;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return countPage;
}
public List<book_show> getBooksByCategoryOrGenre(int categoryId, int genreId, int excludeBookId) {
    List<book_show> bookList = new ArrayList<>();
    String sql = "SELECT * FROM bookdetailed WHERE (categoryID = ? OR gerne_id = ?) AND book_id <> ?";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
        statement.setInt(1, categoryId);
        statement.setInt(2, genreId);
        statement.setInt(3, excludeBookId);
        try (ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                // Create a book_show object from the result set
                book_show book = new book_show();
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("product_name"));
                book.setPrice(rs.getString("price"));
                book.setImage(rs.getString("image"));
                // Add the book to the list
                bookList.add(book);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return bookList;
}


public CategoryGenreInfo getCategoryGenreInfoByBookId(int bookId) {
    CategoryGenreInfo info = null;
    String query = "SELECT categoryID, gerne_id FROM bookdetailed WHERE book_id = ?";

    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, bookId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            info = new CategoryGenreInfo();
            info.setCategoryId(rs.getInt("categoryID"));
            info.setGenreId(rs.getInt("gerne_id"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return info;
}
public Book_Cart getProductbyID(int id){
      String query = "SELECT * FROM bookdetailed WHERE book_id = ?";
      try {
          PreparedStatement st = connection.prepareStatement(query);
          st.setInt(1, id);
          ResultSet rs = st.executeQuery();
          if(rs.next()){
              return new Book_Cart(id,rs.getString("product_name"),rs.getString("image"),rs.getInt("quantity"),rs.getDouble("price"));
          }
    } catch (SQLException e) {
          System.out.println(e);
    }
      return null;
    
}
 public book_detail getBookById(int id) {
        book_detail book = null;
        String query = "SELECT * FROM bookdetailed WHERE book_id = ?";

        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                book = new book_detail();
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("product_name"));
                book.setSupplier(rs.getString("supplier"));
                book.setPublisher(rs.getString("publisher"));
                book.setCover_form(rs.getString("cover_form"));
                book.setPrice(rs.getString("price"));
                book.setAuthor(rs.getString("author"));
                book.setYear_publish(rs.getString("year_publish"));
                book.setLanguage(rs.getString("language"));
                book.setWeight(rs.getString("weight"));
                book.setPackage_size(rs.getString("packaging_size"));
                book.setNum_page(rs.getString("num_pages"));
                book.setDescription(rs.getString("description"));
                book.setImage(rs.getString("image"));
                book.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }
  

}
