# JobPortal.com

A modern job portal application built with Spring Boot, connecting job seekers with recruiters and opportunities.

## 🚀 Features

- **Dual User Roles**: Separate interfaces for Job Seekers and Recruiters
- **Advanced Job Search**: Filter by employment type, location, and date posted
- **Job Management**: Post, edit, and manage job listings
- **Application Tracking**: Track job applications and saved positions
- **Profile Management**: Comprehensive user profiles for both seekers and recruiters
- **Responsive Design**: Modern, mobile-friendly interface

## 🛠️ Tech Stack

- **Backend**: Spring Boot 3.4.1, Spring Security, Spring Data JPA
- **Frontend**: Thymeleaf, Bootstrap 5, jQuery, Font Awesome
- **Database**: MySQL
- **Build Tool**: Maven
- **Java Version**: 21

## 📸 Screenshots

### Login Page
Clean and modern authentication interface with split-screen design.

![Login Page](docs/screenshots/login.png)

### Homepage
Discover thousands of job opportunities with an intuitive search interface.

![Homepage](docs/screenshots/homepage.png)

### Dashboard
Manage your job search or recruitment activities with a streamlined dashboard.

![Dashboard](docs/screenshots/dashboard.png)

## 🎯 Key Functionalities

### For Job Seekers
- Search and filter job listings
- Save favorite jobs
- Apply to positions with one click
- Track application status
- Manage personal profile and resume

### For Recruiters
- Post new job openings
- View and manage applications
- Track candidate engagement
- Edit company profile
- Monitor job posting performance

## 🚦 Getting Started

### Prerequisites
- Java 21 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/jobportal.git
   cd jobportal
   ```

2. **Configure Database**
   
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build the project**
   ```bash
   cd jobportal
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application**
   
   Open your browser and navigate to: `http://localhost:8080`

## 📁 Project Structure

```
jobportal/
├── src/
│   ├── main/
│   │   ├── java/com/portal/jobportal/
│   │   │   ├── config/          # Security & MVC configuration
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── model/           # Entity classes
│   │   │   ├── repository/      # Data access layer
│   │   │   ├── services/        # Business logic
│   │   │   └── Util/            # Utility classes
│   │   └── resources/
│   │       ├── static/          # CSS, JS, images
│   │       ├── templates/       # Thymeleaf templates
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 🎨 Design Features

- **Modern UI**: Clean, gradient-based design with smooth animations
- **Responsive Layout**: Optimized for desktop, tablet, and mobile devices
- **Intuitive Navigation**: Easy-to-use interface for both user types
- **Accessibility**: Form validation and user-friendly error messages

## 🔐 Security

- Spring Security integration
- Password encryption
- Role-based access control (Job Seeker / Recruiter)
- Session management

## 📝 Database Schema

The application uses the following main entities:
- Users & UsersType
- JobSeekerProfile & RecruiterProfile
- JobPostActivity
- JobSeekerApply & JobSeekerSave
- JobCompany & JobLocation
- Skills

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

- Your Name - Initial work

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Bootstrap for the responsive UI components
- Font Awesome for the icon library

## 📞 Support

For support, email support@jobportal.com or open an issue in the repository.

---

**JobPortal.com** - Connect with opportunities that matter
