# Git and GitHub Fundamentals

**Table of Contents:**

- [Git and GitHub Fundamentals](#git-and-github-fundamentals)
  - [Introduction](#introduction)
  - [Branches and Commits](#branches-and-commits)
  - [Pull Requests](#pull-requests)
  - [CLI](#cli)
    - [CLI Commands](#cli-commands)
  - [Git Configurations](#git-configurations)
    - [Language for Commit Messages](#language-for-commit-messages)
  - [Creating a Pull Request](#creating-a-pull-request)
  - [Local vs. Remote](#local-vs-remote)
  - [Moving Project to GitHub](#moving-project-to-github)
  - [Importance of an open-source and public repository.](#importance-of-an-open-source-and-public-repository)

## Introduction

- **Git** is a free and open-source distributed _Version Control System_ (VCS) designed to record changes made to a set of files over time, as well as handle a multitude of tasks regarding software projects with speed and efficiency.
  - When working on a large project, it's possible to revert a file, multiple files, or the entire project to a previous version.
  - There's also the ability to compare different versions of a file to see changes made.
- This allows you the ability to explore new and experimental ideas with your project, with the assurance that you can always go back to a previous version.
- Git is a _distributed_ version control system, meaning every client working in a project has to mirror the entire project everytime they pull from the repository.

  - This means that, if the server's repository is deleted or corrupted, it is very easy to replace with somebody's local version.

- **GitHub** is a collaboration platform that's built on top of Git, with a focus on developers.
  - GitHub builds a playform for developers to create, share and grow.
  - It nurters a community for developers and supports open-source and free projects.
  - Supports beginner as well as experienced developers.

## Branches and Commits

- Inside each version of the repository is also the history of the project, organized into **branches**.
  - These branches are a timeline on how the project has changed over time.
  - Every project that's initalized with Git starts with a single default branch, called `master`. It is usually designated as the _production_ branch.
- When it comes to making changes in the project, regardless of if its a hot-fix, feature edition, or bug squash, it doesn't make sense to make those changes directly on the `master` branch that's going live to production.
  - The solution to this is to make a new alternative timeline, or branch, specifically for the new change where you can add **commits**.
    - Commits are how changes are made within a project on Git, these are recorded in history so they can be reviewed and analyzed.
    - Making a commit is creating a snapshot to your project at that point in time.
  - Essentially, a branch is just a specific point in time where you can try out new ideas and make changes to a full copy of the project, without affecting the `master` branch in a sandbox enviornment.
- Binary files like spreadsheets, presentations with slides, and videos don't work well with Git. If your repository already has some of these files, it's best to have a plan in place before you enable Git version control.

## Pull Requests

- After commiting new code into the feature branch, the next step is submit a **pull request**.
- A pull request is a GitHub operation and collaboration feature.
  - The idea is to have an easy way to display project changes to team members and collaborators compared to the `origin` version.
  - People are then able to comment their remarks on the pull request, with review and discussion.
  - You are still able to make further changes and improvements while your pull request is open, meaning you can take in the feedback and utilize it in your code, so open pull requests early.
- After discussion and review, the next step is to _deploy_ your branch into a testing enviornment, and then _merge_ the branch into the `master`.

Code / Issues / Pull Requests / Projects / Wiki / Insights

## CLI

- Often, it's best to perform Git actions on the **command line interface** (CLI), where you have full freedom and flexibility to make the changes you need.
  - The CLI is the only place where you can run _all_ Git commands in their full functionality in a standardized fashion.
  - Knowing Git on the command line transfers over to other tools as well.
- On Windows, the best CLI tools are _Git Bash_ and _Powershell_ to get started.
- For Mac or Linux, the _Terminal_ is the best place to get started.

### CLI Commands

- `pwd` - Prints the working directory.
- `cd` - Changes the directory and lets you navigate into different directories.
- `ls` - Lists files in the directory you're currently in. `dir` on Windows.
- `touch` - Creates an empty file within the working directory. `copy con` on Windows.
- `mkdir` - Creates an empty folder within the working directory.
- `git --version` - Checks if Git is installed on the current local machine.

## Git Configurations

- When it comes to Git configuration levels, there are three different scopes available.
  - `--system` applies to all users on a system.
  - `--global` applies to the current user.
  - `--local` applies to only the specific repository.
- Needed configurations before making any commits: -`git config --global user.name "brennanbrown" -`git config --global user.email "brennan.brown@edu.sait.ca"
- Git commits are silent when successful, producing no output on the CLI.

### Language for Commit Messages

- Don’t end your commit message with a period.
- Keep your commit messages to 50 characters or less.
  - Add extra detail in the extended description window if necessary. This is located just below the subject line.
- Use active voice. For example, "add" instead of "added" and "merge" instead of "merged".
- Think of your commit as expressing intent to introduce a change.

```bash

## Steps to Local Git Repository ##

# Clone the repository to your local files.
git clone https://github.com/username/project.git

# Navigate to the repository in the shell.
cd project

# Create a new branch.
git branch project-testing

# Push the branch to GitHub.
git push --set-upstream origin project-testing


## Committing a File ##

# Check out to your branch
git checkout project-testing

# Check status of the project
# git status

# Create a new file.
touch _posts/0000-01-01-hello-world.md

# Add content to the file.
geany _posts/0000-01-01-hello-world.md

# Stage the new file.
git add _posts/0000-01-01-hello-world.md

# Commit the change and add a message.
git commit -m "Create 0000-01-01-hello-world.md"

# Push the commit to the repository
git push


## Merge a Pull Request ##

# Check out to the master branch.
git checkout master

# Merge your branch.
git merge project-testing

# Push the merged history to GitHub.
git push

# Delete your branch locally.
git branch -d project-testing

```

- There are three states that a file can be in when in a repository:
  - _Working_ - When a file has been created or modified, A sandbox environment, nothing is being saved or pushed back up to GitHub.
  - _Staging_ (Index) - When you want to move forward with changes you've made to a file, `git add` moves them to the stanging area, waiting to be committed.
  - _History_ (.git directory) - When you run `git commit` all files in the staging area will be added to the local project's history, which can then be pushed up to the repository being hosted on GitHub.

## Creating a Pull Request

- From the "Pull requests" tab, click New pull request
- In the `"base:"` drop-down menu, make sure the `"master"` branch is selected
- In the `"compare:"` drop-down menu, select `"project-testing"`
- When you’ve selected your branch, enter a title for your pull request.
  - For example Add username's file
- The next field helps you provide a description of the changes you made.
  - Feel free to add a description of what you’ve accomplished so far. As a reminder, you have: created a branch, created a file and made a commit, and opened a pull request
- Click "Create pull request".

## Local vs. Remote

- When you pull a project, you have the complete history as well as the files. No online network is required.
  - This means that all git operations do not require a connection with the remote server, making them instantaneous.
- Git is explict, meaning it won't work with the remote server unless manually told to do so with commands.
- Checking out a local branch automatically creates a tacking branch.
  - Remote tracking branches as as bookmarks to remind you where your branches on your remote repositories were the last time you connected with them.
  - Git knowns which branch to push to.
- `fetch origin` tells when the loast time changes were pulled down from the GitHub.com repository.

- If interested in a GUI program to operate Git with, [git-scm](https://git-scm.com/downloads/guis) is the place to check them out.
  - _GitHub Desktop_ has unified experience between Mac and Windows, as the program is built on the cross-platform _electron_.

## Moving Project to GitHub

```bash

# Create a new repository locally.
git init project-upload

# Enter the new folder
cd project-upload

# Create a file for listing files that are not
# to be included in the Git repository.
touch .gitignore

# Edit the file to write out what's not to be
# included.
geany .gitignore

# Add a readme to the repository to explain
# what the project is about.
touch README.md

# Edit the file to write out what the project
# is about.
geany README.md

# Add the two new files to the staging area (index)
git add .gitignore README.md

# This URL is where the project is going to exist
# on GitHub.
git remote add origin https://github.com/brennanbrown/github-upload.git

# Adds all the changes that have been made.
git add .

# Pushes project up to the origin master branch
# for the first time.
git commit -m "Initalize repository"

git push -u origin master t
```

## Importance of an open-source and public repository.

- When a project is open-source, it means that anybody can view, modify, and distribute the project for any purpose.
  - This lowers the barries to adoption.
  - Improves the overall product, and gets gelp from credible sources within the community
  - Increases transparency and ownership to the project.
- In addition, by contributing and consuming open-source material, it helps reduce the duplication of work to fix a similar problem.
- For more information, visit [Open Source Guide](https://opensource.guide) and [GitHub School](https://github.com/githubschool)
