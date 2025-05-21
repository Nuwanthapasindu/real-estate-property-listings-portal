<%--
  Created by IntelliJ IDEA.
  User: janidulonethdemel
  Date: 2025-05-21
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - Profile</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/dashboard/dashboard.css">
</head>
<body>
<div class="dashboard-container">
    <jsp:include page="/components/dashboard-side.jsp" />

    <!-- Main Content -->
    <div class="main-content">
        <!-- Header with greeting -->
        <div class="dashboard-header">
            <h2>Hello <%= session.getAttribute("firstName") %> <%= session.getAttribute("lastName") %></h2>
        </div>

        <!-- Profile Update Form -->
        <div class="properties-section">
            <div class="row">
                <div class="col-md-12   ">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title mb-4">Update Profile</h3>
                            
                            <% String error = request.getParameter("error"); %>
                            <% if (error != null) { %>
                            <div class="alert alert-danger" role="alert">
                                <%= error %>
                            </div>
                            <% } %>

                            <% String success = request.getParameter("success"); %>
                            <% if (success != null) { %>
                            <div class="alert alert-success" role="alert">
                                Profile updated successfully!
                            </div>
                            <% } %>

                            <form action="" method="post">
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <label for="firstName" class="form-label">First Name</label>
                                        <input type="text" class="form-control" id="firstName" name="firstName" 
                                               value="<%= session.getAttribute("firstName") %>" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="lastName" class="form-label">Last Name</label>
                                        <input type="text" class="form-control" id="lastName" name="lastName" 
                                               value="<%= session.getAttribute("lastName") %>" required>
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" 
                                           value="<%= session.getAttribute("email") %>" required>
                                </div>

                                <div class="mb-3">
                                    <label for="phone" class="form-label">Phone Number</label>
                                    <input type="tel" class="form-control" id="phone" name="contactNumber"
                                           value="<%= session.getAttribute("contactNumber") %>" required>
                                </div>

                                <hr class="my-4">

                                <div class="mb-3">
                                    <label for="newPassword" class="form-label">New Password (Optional)</label>
                                    <input type="password" class="form-control" id="newPassword" 
                                           name="newPassword" placeholder="Leave blank to keep current password">
                                </div>

                                <div class="mb-3">
                                    <label for="confirmPassword" class="form-label">Confirm New Password</label>
                                    <input type="password" class="form-control" id="confirmPassword" 
                                           name="confirmPassword" placeholder="Confirm new password">
                                </div>

                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                    <button type="button" class="btn btn-outline-secondary me-md-2">Cancel</button>
                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Delete Account Section -->
        <div class="card mt-4 border-danger">
            <div class="card-body">
                <h4 class="card-title text-danger">Delete Account</h4>
                <p class="card-text">Warning: This action cannot be undone. All your data will be permanently deleted.</p>
                
              <form action="<%=request.getContextPath()%>/auth/publisher/delete" method="post" >
                  <!-- Delete Account Button with Modal -->
                  <button type="submit" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteAccountModal">
                      Delete Account
                  </button>
              </form>
            </div>
        </div>

        <!-- Delete Account Modal -->
        <div class="modal fade" id="deleteAccountModal" tabindex="-1" aria-labelledby="deleteAccountModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-danger" id="deleteAccountModalLabel">Confirm Account Deletion</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete your account? This action cannot be undone and will result in:</p>
                        <ul>
                            <li>Permanent deletion of your profile information</li>
                            <li>Removal of all your listed properties</li>
                            <li>Loss of access to all services</li>
                        </ul>
                        <form action="<%= request.getContextPath() %>/auth/publisher/profile/delete" method="post" id="deleteAccountForm">
                            <div class="mb-3">
                                <label for="deleteConfirmation" class="form-label">Type "DELETE" to confirm:</label>
                                <input type="text" class="form-control" id="deleteConfirmation" 
                                       required pattern="DELETE" title="Please type DELETE to confirm">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="submit" form="deleteAccountForm" class="btn btn-danger">Delete Account</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/dashboard/dashboard.js"></script>
</body>
</html>