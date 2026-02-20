# 📤 Push to GitHub - Step by Step Guide

## 🎯 Repository Information
- **GitHub URL**: https://github.com/sabarisan28/Hot-Wheels-Webpage
- **Repository Name**: Hot-Wheels-Webpage

## 📋 Prerequisites

1. ✅ Git installed (version 2.52.0.windows.1)
2. ✅ GitHub account created
3. ✅ Repository created on GitHub

## 🚀 Step-by-Step Instructions

### Step 1: Initialize Git Repository

```bash
# Navigate to project directory
cd "C:\Users\sabar\OneDrive\Desktop\hot wheels"

# Initialize git repository
git init
```

### Step 2: Configure Git (First Time Only)

```bash
# Set your name
git config --global user.name "sabarisan28"

# Set your email
git config --global user.email "aathisenthil18@gmail.com"
```

### Step 3: Add Remote Repository

```bash
# Add GitHub repository as remote
git remote add origin https://github.com/sabarisan28/Hot-Wheels-Webpage.git

# Verify remote was added
git remote -v
```

### Step 4: Add Files to Git

```bash
# Add all files (respects .gitignore)
git add .

# Check what will be committed
git status
```

### Step 5: Commit Changes

```bash
# Commit with message
git commit -m "Initial commit: Hot Wheels E-Commerce Store

- Added Spring Boot backend with 54 products
- Added frontend with shopping cart
- Implemented user authentication with BCrypt
- Added product images (56 images)
- Configured Supabase PostgreSQL database
- Added admin panel
- Full CRUD operations for products, users, and orders"
```

### Step 6: Push to GitHub

```bash
# Push to main branch
git branch -M main
git push -u origin main
```

If you get authentication error, you'll need to use a Personal Access Token (PAT).

---

## 🔐 GitHub Authentication

### Option 1: Personal Access Token (Recommended)

1. **Generate Token**
   - Go to: https://github.com/settings/tokens
   - Click "Generate new token (classic)"
   - Select scopes: `repo` (all)
   - Click "Generate token"
   - **Copy the token immediately** (you won't see it again!)

2. **Use Token When Pushing**
   ```bash
   # When prompted for password, paste your token
   git push -u origin main
   
   # Username: sabarisan28
   # Password: [paste your token here]
   ```

3. **Save Credentials (Optional)**
   ```bash
   # Save credentials so you don't have to enter token every time
   git config --global credential.helper store
   ```

### Option 2: SSH Key

1. **Generate SSH Key**
   ```bash
   ssh-keygen -t ed25519 -C "aathisenthil18@gmail.com"
   ```

2. **Add SSH Key to GitHub**
   - Copy the public key:
   ```bash
   cat ~/.ssh/id_ed25519.pub
   ```
   - Go to: https://github.com/settings/keys
   - Click "New SSH key"
   - Paste the key and save

3. **Change Remote to SSH**
   ```bash
   git remote set-url origin git@github.com:sabarisan28/Hot-Wheels-Webpage.git
   ```

---

## 📝 Complete Command Sequence

Here's the complete sequence to run:

```bash
# 1. Initialize repository
git init

# 2. Configure git (if not done before)
git config --global user.name "sabarisan28"
git config --global user.email "aathisenthil18@gmail.com"

# 3. Add remote
git remote add origin https://github.com/sabarisan28/Hot-Wheels-Webpage.git

# 4. Add all files
git add .

# 5. Commit
git commit -m "Initial commit: Hot Wheels E-Commerce Store"

# 6. Push to GitHub
git branch -M main
git push -u origin main
```

---

## 🔍 Verify Upload

After pushing, verify on GitHub:

1. Go to: https://github.com/sabarisan28/Hot-Wheels-Webpage
2. You should see:
   - ✅ README.md displayed
   - ✅ backend/ folder
   - ✅ index.html
   - ✅ server.js
   - ✅ All documentation files
   - ✅ .gitignore file

---

## 📊 What Will Be Uploaded

### ✅ Files to Upload (Important)
```
✅ backend/src/main/java/          (All Java source code)
✅ backend/src/main/resources/     (Config files + images)
✅ backend/pom.xml                 (Maven configuration)
✅ index.html                      (Frontend)
✅ server.js                       (Node.js server)
✅ hot.html                        (Original frontend)
✅ README.md                       (Documentation)
✅ .gitignore                      (Git ignore rules)
✅ All .md documentation files
✅ Product images (56 images)
```

### ❌ Files NOT Uploaded (Ignored)
```
❌ backend/target/                 (Compiled files)
❌ .idea/                          (IDE settings)
❌ .vscode/                        (IDE settings)
❌ node_modules/                   (If exists)
❌ *.class files                   (Compiled Java)
❌ *.log files                     (Log files)
```

---

## 🐛 Troubleshooting

### Problem: "fatal: not a git repository"
**Solution:**
```bash
git init
```

### Problem: "remote origin already exists"
**Solution:**
```bash
git remote remove origin
git remote add origin https://github.com/sabarisan28/Hot-Wheels-Webpage.git
```

### Problem: "Authentication failed"
**Solution:**
- Use Personal Access Token instead of password
- Or set up SSH key (see above)

### Problem: "Updates were rejected"
**Solution:**
```bash
# Pull first, then push
git pull origin main --allow-unrelated-histories
git push -u origin main
```

### Problem: "Large files"
**Solution:**
```bash
# Check file sizes
git ls-files -s | awk '{print $4, $2}' | sort -n -r | head -20

# If needed, remove large files
git rm --cached large-file.jar
git commit -m "Remove large file"
```

---

## 📦 After Pushing

### Update README on GitHub
1. Go to your repository
2. Edit README.md if needed
3. Add screenshots
4. Update documentation

### Add Topics/Tags
1. Go to repository settings
2. Add topics: `java`, `spring-boot`, `e-commerce`, `hot-wheels`, `postgresql`, `javascript`

### Enable GitHub Pages (Optional)
1. Go to Settings → Pages
2. Select branch: main
3. Select folder: / (root)
4. Save

---

## 🎉 Success!

After successful push, your repository will be live at:
**https://github.com/sabarisan28/Hot-Wheels-Webpage**

Share it with:
- Potential employers
- Friends and colleagues
- On LinkedIn
- In your portfolio

---

## 📝 Future Updates

To push future changes:

```bash
# 1. Check status
git status

# 2. Add changes
git add .

# 3. Commit
git commit -m "Description of changes"

# 4. Push
git push
```

---

## 🔗 Useful Git Commands

```bash
# View commit history
git log --oneline

# View remote URL
git remote -v

# View current branch
git branch

# Create new branch
git checkout -b feature-name

# Switch branch
git checkout main

# Pull latest changes
git pull

# View changes
git diff

# Undo last commit (keep changes)
git reset --soft HEAD~1

# Undo last commit (discard changes)
git reset --hard HEAD~1
```

---

Good luck with your GitHub upload! 🚀
