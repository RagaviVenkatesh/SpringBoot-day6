**Spring Boot Day 6 Exercise**
Exercise Title: One-to-Many Relationship - User and Posts

Objective:

Today you will implement a one-to-many relationship between User and Posts. Each user can have
multiple posts. You will create entities, repositories, services, and controllers for both User and Post.

Requirements:

1. Create a Post entity with fields: id, title, content, user (as a foreign key).
2. Annotate the relationship in User with @OneToMany(mappedBy = "user") and in Post with
@ManyToOne.
3. Create PostDTO with id, title, content, and userId.
4. Use ModelMapper to convert between Post and PostDTO.
5. Create PostRepository, PostService, and PostController.
6. Implement APIs:
 - GET /api/posts - fetch all posts
 - GET /api/posts/user/{userId} - fetch posts by user
 - POST /api/posts - create a new post for a user
7. Validate PostDTO with @NotBlank on title and content.
8. Test using Postman with different users and post data.
Bonus Task (Optional):
In GET /api/users, include the count of posts made by each user using a custom field in UserDTO.
Submission Checklist:
- Post entity and User entity are related correctly
- PostDTO used in controller and validated
- APIs for post creation and retrieval are working
- ModelMapper used for conversion
- Bonus task implemented (if attempted)
