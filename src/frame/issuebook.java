/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author kaazif
 */
public class issuebook extends javax.swing.JFrame {

    /**
     * Creates new form issuebook
     */
    public issuebook() {
        initComponents();
    }

    public void getbookDetails() {
        int bookId = Integer.parseInt(txtbookID.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pat = con.prepareStatement("select * from book_details where book_id =?");
            pat.setInt(1, bookId);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lblauthor.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
            } else {
                lblbookerror.setText("invalid Book Id");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStudentDetails() {
        int studentid = Integer.parseInt(txtstudentid.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pat = con.prepareStatement("select * from student_details where student_id =?");
            pat.setInt(1, studentid);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                lbl_studentid.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_branch.setText(rs.getString("branch"));
            } else {
                lblstudenterror.setText("Invalid Student Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean issuebook() {
        boolean isIssued = false;
        int bookId = Integer.parseInt(txtbookID.getText());
        int studentId = Integer.parseInt(txtstudentid.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();

        Date uIssuedate = date_issuedate.getDatoFecha();
        Date uDuedate = Date_duedate.getDatoFecha();
        
        Long l1 = uIssuedate.getTime();
        Long l2 = uDuedate.getTime();

        java.sql.Date sIssuedate = new java.sql.Date(l1);
        java.sql.Date sDuedate = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status)values(?,?,?,?,?,?,?)";
            PreparedStatement pat = con.prepareStatement(sql);
            pat.setInt(1, bookId);
            pat.setString(2, bookName);
            pat.setInt(3, studentId);
            pat.setString(4, studentName);
            pat.setDate(5, sIssuedate);
            pat.setDate(6, sDuedate);
            pat.setString(7, "pending");
            
            int rowCount = pat.executeUpdate();
            if (rowCount >0) {
                isIssued = true;
              
            }else{
                isIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;

    }
    public void updateBookCOunt(){
        int bookId = Integer.parseInt(txtbookID.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity -1 where book_id =?";
            PreparedStatement pat = con.prepareStatement(sql);
            pat.setInt(1, bookId);
            
            int rowCount = pat.executeUpdate();
            
             if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book Count Updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
              
            }else{
                JOptionPane.showMessageDialog(this, "cant update book count");;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean IsAlreadyIssued(){
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(txtbookID.getText());
        int studentId = Integer.parseInt(txtstudentid.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql ="select * from issue_book_details where book_id =? and student_id =? and status =?";
            PreparedStatement pat = con.prepareStatement(sql);
            pat.setInt(1, bookId);
            pat.setInt(2, studentId);
            pat.setString(3, "pending");
            
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                isAlreadyIssued = true;
              
            }else{
                isAlreadyIssued = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lblauthor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblbookerror = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        lbl_studentid = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lblstudenterror = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtbookID = new app.bolivia.swing.JCTextField();
        txtstudentid = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        date_issuedate = new rojeru_san.componentes.RSDateChooser();
        jLabel19 = new javax.swing.JLabel();
        Date_duedate = new rojeru_san.componentes.RSDateChooser();
        jLabel20 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        lbl_quantity1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(java.awt.Color.white);
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText(" back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("Book Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Book Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Author  :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, 40));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Book ID :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbl_quantity.setForeground(java.awt.Color.white);
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 190, 30));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbl_bookId.setForeground(java.awt.Color.white);
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 190, 30));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbl_bookName.setForeground(java.awt.Color.white);
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 190, 30));

        lblauthor.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblauthor.setForeground(java.awt.Color.white);
        jPanel1.add(lblauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 190, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Quantity  :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        lblbookerror.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jPanel1.add(lblbookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 270, 30));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(java.awt.Color.white);
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel11.setText("Student Details");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("Branch  :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setText("StudentName :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setText("Course  :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText("Student ID :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbl_branch.setForeground(java.awt.Color.white);
        jPanel3.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 190, 30));

        lbl_studentid.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbl_studentid.setForeground(java.awt.Color.white);
        jPanel3.add(lbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 190, 30));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbl_studentName.setForeground(java.awt.Color.white);
        jPanel3.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 190, 30));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbl_course.setForeground(java.awt.Color.white);
        jPanel3.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 190, 30));

        lblstudenterror.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jPanel3.add(lblstudenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 270, 30));

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 420, 810));

        jLabel12.setBackground(java.awt.Color.white);
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel12.setForeground(java.awt.Color.red);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel12.setText("Isssue Book");
        panel_main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 140, -1, 50));

        jPanel7.setBackground(java.awt.Color.black);
        jPanel7.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 220, -1, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("Book ID :");
        panel_main.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, -1, -1));

        txtbookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txtbookID.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtbookID.setPlaceholder("Enter Book ID..............");
        txtbookID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbookIDKeyReleased(evt);
            }
        });
        panel_main.add(txtbookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, 310, 40));

        txtstudentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txtstudentid.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtstudentid.setPlaceholder("Enter Student Id..............");
        txtstudentid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtstudentidKeyReleased(evt);
            }
        });
        panel_main.add(txtstudentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 360, 310, 40));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Issused Date :");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, -1, -1));

        date_issuedate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_issuedate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_issuedate.setFuente(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        date_issuedate.setPlaceholder("Select Issue Date");
        panel_main.add(date_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 450, 320, -1));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("Student ID :");
        panel_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 370, -1, -1));

        Date_duedate.setColorBackground(new java.awt.Color(255, 51, 51));
        Date_duedate.setColorForeground(new java.awt.Color(255, 51, 51));
        Date_duedate.setFuente(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Date_duedate.setPlaceholder("Select Due Date");
        panel_main.add(Date_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 540, 320, -1));

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("Due Date :");
        panel_main.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 550, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Issue Book");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 630, 360, 70));

        lbl_quantity1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbl_quantity1.setForeground(java.awt.Color.white);
        panel_main.add(lbl_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 190, 30));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        if (lbl_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Book is not Available");
            
        }
        else{
            if (IsAlreadyIssued() == false) {
           if (issuebook() == true) {
            JOptionPane.showMessageDialog(this, "Book Isssued Successfully");
            updateBookCOunt();
            
        }else{
            JOptionPane.showMessageDialog(this, "Book canr be Issued");
        } 
        }else{
            JOptionPane.showMessageDialog(this, "This Student Already has this book");
        }
        }
        
        
        
        

    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void txtbookIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbookIDKeyReleased
        // TODO add your handling code here:
        if (!txtbookID.getText().equals("")) {
            getbookDetails();
        }
    }//GEN-LAST:event_txtbookIDKeyReleased

    private void txtstudentidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstudentidKeyReleased
        // TODO add your handling code here:
        if (!txtstudentid.getText().equals("")) {
            getStudentDetails();
        }
    }//GEN-LAST:event_txtstudentidKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(issuebook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new issuebook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser Date_duedate;
    private rojeru_san.componentes.RSDateChooser date_issuedate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_quantity1;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JLabel lbl_studentid;
    private javax.swing.JLabel lblauthor;
    private javax.swing.JLabel lblbookerror;
    private javax.swing.JLabel lblstudenterror;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txtbookID;
    private app.bolivia.swing.JCTextField txtstudentid;
    // End of variables declaration//GEN-END:variables
}
