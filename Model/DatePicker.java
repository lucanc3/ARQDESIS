package Model;
/*
 * Decompiled with CFR 0_114.
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.border.Border;

public class DatePicker
extends JPanel {
    private static final long serialVersionUID = 1;
    protected boolean controlsOnTop;
    protected boolean removeOnDaySelection;
    protected Calendar currentDisplayDate;
    protected JButton prevMonth;
    protected JButton nextMonth;
    protected JButton prevYear;
    protected JButton nextYear;
    protected JTextField textField;
    protected List<ActionListener> popupListeners = new ArrayList<ActionListener>();
    protected Popup popup;
    protected SimpleDateFormat dayName = new SimpleDateFormat("d");
    protected SimpleDateFormat monthName = new SimpleDateFormat("MMMM");
    protected String iconFile = "datepicker.gif";
    protected String[] weekdayNames = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    public DatePicker() {
        this.currentDisplayDate = Calendar.getInstance();
        this.controlsOnTop = true;
        this.removeOnDaySelection = true;
        this.createPanel();
    }

    public DatePicker(Calendar date) {
        this.setDate(date);
        this.controlsOnTop = true;
        this.removeOnDaySelection = true;
        this.createPanel();
    }

    public DatePicker(int month, int day, int year) {
        this.setDate(month, day, year);
        this.controlsOnTop = true;
        this.removeOnDaySelection = true;
        this.createPanel();
    }

    public void setDate(String date) {
        this.currentDisplayDate = Calendar.getInstance();
        this.editDate(date);
    }

    public void setDate(Calendar date) {
        this.currentDisplayDate = date;
        this.createPanel();
        this.validate();
        this.repaint();
    }

    public void setDate(int month, int day, int year) {
        this.currentDisplayDate = Calendar.getInstance();
        this.currentDisplayDate.set(this.expandYear(year), month - 1, day);
        this.createPanel();
        this.validate();
        this.repaint();
    }

    protected int expandYear(int year) {
        if (year < 100) {
            int currentYear = Calendar.getInstance().get(1);
            int current2DigitYear = currentYear % 100;
            int currentCentury = currentYear / 100 * 100;
            int high2DigitYear = (current2DigitYear + 20) % 100;
            year = year <= high2DigitYear ? (year += currentCentury) : (year += currentCentury - 100);
        }
        return year;
    }

    public void setControlsOnTop(boolean flag) {
        this.controlsOnTop = flag;
        this.createPanel();
        this.validate();
        this.repaint();
    }

    public void setRemoveOnDaySelection(boolean flag) {
        this.removeOnDaySelection = flag;
    }

    public Popup getPopup(Container c) {
        if (this.popup == null) {
            Point p = c.getLocation();
            PopupFactory factory = PopupFactory.getSharedInstance();
            this.popup = factory.getPopup(c, this, p.x, p.y);
        }
        return this.popup;
    }

    public void popupShow(Container c) {
        this.getPopup(c);
        this.popup.show();
    }

    public void popupHide() {
        this.popup.hide();
    }

    public Calendar getCalendarDate() {
        return this.currentDisplayDate;
    }

    public Date getDate() {
        return this.currentDisplayDate.getTime();
    }

    public String getFormattedDate() {
        return String.valueOf(Integer.toString(this.getMonth())) + "/" + Integer.toString(this.getDay()) + "/" + Integer.toString(this.getYear());
    }

    public int getMonth() {
        return this.currentDisplayDate.get(2) + 1;
    }

    public int getDay() {
        return this.currentDisplayDate.get(5);
    }

    public int getYear() {
        return this.currentDisplayDate.get(1);
    }

    public ImageIcon getImage() {
        return this.createImageIcon(this.iconFile, "Calendar date picker");
    }

    protected ImageIcon createImageIcon(String path, String description) {
        URL imgURL = this.getClass().getResource(path);
        String fileName = imgURL.getFile().replace("bin/", "src/");
        fileName = fileName.replace("%20", " ").substring(1);
        ImageIcon icon = new ImageIcon(fileName, description);
        return icon;
    }

    protected void createPanel() {
        this.removeAll();
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.setFocusable(true);
        this.setLayout(new BoxLayout(this, 1));
        if (this.controlsOnTop) {
            this.add(this.createControls());
            this.add(this.createCalendar());
        } else {
            this.add(this.createCalendar());
            this.add(this.createControls());
        }
        Dimension d = this.getPreferredSize();
        this.setPreferredSize(new Dimension(d.width, d.height + 8));
    }

    protected JPanel createControls() {
        JPanel c = new JPanel();
        c.setBorder(BorderFactory.createRaisedBevelBorder());
        c.setFocusable(true);
        c.setLayout(new FlowLayout(1));
        this.prevYear = new JButton("<<");
        c.add(this.prevYear);
        this.prevYear.setMargin(new Insets(0, 0, 0, 0));
        this.prevYear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                DatePicker.this.addYear(-1);
            }
        });
        this.prevMonth = new JButton("<");
        c.add(this.prevMonth);
        this.prevMonth.setMargin(new Insets(0, 0, 0, 0));
        this.prevMonth.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                DatePicker.this.addMonth(-1);
            }
        });
        this.textField = new JTextField(this.getFormattedDate(), 10);
        c.add(this.textField);
        this.textField.setEditable(true);
        this.textField.setEnabled(true);
        this.textField.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DatePicker.this.editDate(DatePicker.this.textField.getText());
            }
        });
        this.nextMonth = new JButton(">");
        c.add(this.nextMonth);
        this.nextMonth.setMargin(new Insets(0, 0, 0, 0));
        this.nextMonth.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                DatePicker.this.addMonth(1);
            }
        });
        this.nextYear = new JButton(">>");
        c.add(this.nextYear);
        this.nextYear.setMargin(new Insets(0, 0, 0, 0));
        this.nextYear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                DatePicker.this.addYear(1);
            }
        });
        return c;
    }

    protected JPanel createCalendar() {
        JPanel x = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        x.setFocusable(true);
        x.setLayout(gridbag);
        String month = this.monthName.format(this.currentDisplayDate.getTime());
        String year = Integer.toString(this.getYear());
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 7;
        c.gridheight = 1;
        JLabel title = new JLabel(String.valueOf(month) + " " + year);
        x.add((Component)title, c);
        Font font = title.getFont();
        Font weekFont = new Font(font.getName(), font.getStyle(), font.getSize() - 2);
        title.setFont(font);
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        while (c.gridx < 7) {
            JLabel label = new JLabel(this.weekdayNames[c.gridx]);
            x.add((Component)label, c);
            label.setFont(weekFont);
            ++c.gridx;
        }
        Calendar draw = (Calendar)this.currentDisplayDate.clone();
        draw.set(5, 1);
        draw.add(5, - draw.get(7) + 1);
        int monthInt = this.currentDisplayDate.get(2);
        c.gridwidth = 1;
        c.gridheight = 1;
        int width = this.getFontMetrics(weekFont).stringWidth(" Wed ");
        int width1 = this.getFontMetrics(weekFont).stringWidth("Wed");
        int height = this.getFontMetrics(weekFont).getHeight() + (width - width1);
        c.gridy = 2;
        while (c.gridy < 8) {
            c.gridx = 0;
            while (c.gridx < 7) {
                JButton dayButton;
                if (draw.get(2) == monthInt) {
                    String dayString = this.dayName.format(draw.getTime());
                    if (draw.get(5) < 10) {
                        dayString = " " + dayString;
                    }
                    dayButton = new JButton(dayString);
                } else {
                    dayButton = new JButton();
                    dayButton.setEnabled(false);
                }
                x.add((Component)dayButton, c);
                Color color = dayButton.getBackground();
                if (draw.get(5) == this.getDay() && draw.get(2) == monthInt) {
                    dayButton.setBackground(Color.yellow);
                } else {
                    dayButton.setBackground(color);
                }
                dayButton.setFont(weekFont);
                dayButton.setFocusable(true);
                dayButton.setPreferredSize(new Dimension(width, height));
                dayButton.setMargin(new Insets(0, 0, 0, 0));
                dayButton.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DatePicker.this.changeDay(e.getActionCommand());
                    }
                });
                draw.add(5, 1);
                ++c.gridx;
            }
            ++c.gridy;
        }
        return x;
    }

    public void addMonth(int month) {
        this.currentDisplayDate.add(2, month);
        this.createPanel();
        this.validate();
        this.repaint();
    }

    public void addYear(int year) {
        this.currentDisplayDate.add(1, year);
        this.createPanel();
        this.validate();
        this.repaint();
    }

    public void editDate(String date) {
        this.parseDate(date);
        this.createPanel();
        this.validate();
        this.repaint();
    }

    protected void parseDate(String date) {
        String[] parts = date.split("/");
        if (parts.length == 3) {
            this.currentDisplayDate.set(2, Integer.valueOf(parts[0]) - 1);
            this.currentDisplayDate.set(5, Integer.valueOf(parts[1]));
            this.currentDisplayDate.set(1, this.expandYear(Integer.valueOf(parts[2])));
        } else if (parts.length == 2) {
            this.currentDisplayDate = Calendar.getInstance();
            this.currentDisplayDate.set(2, Integer.valueOf(parts[0]) - 1);
            this.currentDisplayDate.set(5, Integer.valueOf(parts[1]));
        } else {
            this.currentDisplayDate = Calendar.getInstance();
        }
    }

    public void changeDay(String day) {
        this.currentDisplayDate.set(5, Integer.valueOf(day.trim()));
        if (this.removeOnDaySelection) {
            this.firePopupEvent(new ActionEvent(this, 1, "hide"));
            this.popup = null;
        } else {
            this.createPanel();
            this.validate();
            this.repaint();
        }
    }

    public void addPopupListener(ActionListener l) {
        this.popupListeners.add(l);
    }

    public void removePopupListener(ActionListener l) {
        this.popupListeners.remove(l);
    }

    public void firePopupEvent(ActionEvent e) {
        int i = this.popupListeners.size() - 1;
        while (i >= 0) {
            ActionListener l = this.popupListeners.get(i);
            l.actionPerformed(e);
            --i;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Date Picker");
        Container pane = frame.getContentPane();
        frame.setDefaultCloseOperation(3);
        frame.setPreferredSize(new Dimension(450, 250));
        pane.setLayout(new FlowLayout(0));
        pane.add(new JLabel("Birthdate: "));
        final JTextField testDate = new JTextField(10);
        pane.add(testDate);
        final DatePicker dp = new DatePicker();
        ImageIcon ii = dp.getImage();
        final JButton datePicker = new JButton(ii);
        pane.add(datePicker);
        datePicker.setPreferredSize(new Dimension(30, 24));
        datePicker.setMargin(new Insets(0, 0, 0, 0));
        datePicker.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DatePicker.this.setDate(testDate.getText());
                DatePicker.this.popupShow(datePicker);
            }
        });
        dp.addPopupListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField.this.setText(dp.getFormattedDate());
                dp.popupHide();
            }
        });
        frame.pack();
        frame.setFocusable(true);
        frame.setResizable(true);
        frame.setVisible(true);
    }

}

