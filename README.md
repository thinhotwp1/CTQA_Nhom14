1. Clone project về, ở file MySQLConnection dường dẫn src\main\java\config\MySQLConnection.java sửa:
private static final String PASSWORD = "thjnhotwp1"; 
thành password tài khoản root của mysql trên máy, mặc định sẽ sửa thành:
private static final String PASSWORD = "root"; 
2. Mở MySQL local và tạo database mới bằng lệnh:
Create database ctqa;
3. Chạy project bằng cách chạy file Login ở path: src\main\java\view\LoginForm.java
Tài khoản Admin/pass: admin/1
Tài khoản nhân viên/pass: nv/1
