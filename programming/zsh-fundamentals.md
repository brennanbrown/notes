# Zsh Fundamentals

- [Zsh Fundamentals](#zsh-fundamentals)
  - [Zsh Foundations](#zsh-foundations)
    - [Installation](#installation)
    - [Zsh as primary shell](#zsh-as-primary-shell)
    - [Environment and Options](#environment-and-options)
    - [Aliases and Reserved Words](#aliases-and-reserved-words)
    - [Functions](#functions)
    - [Builtins and Commands](#builtins-and-commands)
  - [Using Zsh](#using-zsh)
    - [Autocd and cd Shorthand](#autocd-and-cd-shorthand)
    - [Directory Stacks](#directory-stacks)
    - [Finding Files and Commands](#finding-files-and-commands)
    - [Auto Complete](#auto-complete)
    - [Redirection, Pipes, and Multios](#redirection-pipes-and-multios)
  - [Customizing Zsh](#customizing-zsh)

## Zsh Foundations

* To interact with a computer using text at a console or in a terminal window, we type commands that the system runs. 
    - The text environment where we type the commands is called a shell, and there are many different shells out there. 
    - Z shell is a popular choice for developers, system administrators, power users and all kinds of other users. It offers a lot of features that make interacting with the system at the command line fast, easy and powerful. 
* A shell is a space where we can interact with the system using text commands. But a shell is a lot more than just a little box where we type. It's easy to forget that a shell is a program of its own.

### Installation

* Z-Shell is available through the packet managers for a wide variety of Linux distros. 
    - For Unix clients and for OpenBSD and FreeBSD and as of Mac OS 10.15, it comes as the default shell as well. So if you're using that version of the platform you don't need to install Zsh. 
    - For older versions of Mac OS, you can install Zsh with a package manager like Homebrew. 
    - On Windows, it can be installed in Windows Subsystem for Linux using the package manager of your chosen distro. And you can also install it directly in Windows 10 using the WinZsh package.
    - If you're feeling adventurous, you can also build Z-shell from source, which is available from the projects page on SourceForge.

Ubuntu installation:

    $ sudo apt install zsh
    # Initially launch the config wizard
    $ zsh
    # Relaunch the config wizard
    $ autoload -U zsh-newuser-install; zsh-newuser-install 

### Zsh as primary shell

* Most Linux systems, many Unix systems, and versions of Mac OS prior to 10.15 use Bash as their primary shell.
* To set Z shell as the default shell, you'll need to know where it's located on the system, and for that, we can use the command `which zsh`.
    - On Ubuntu, it's located at `/usr/bin/zsh`.
* To change the shell, you can use the `chsh -s /usr/bin/zsh user` command, or `sudo usermod -s /usr/bin/zsh user`.

### Environment and Options

* Within the shell, there are a set of variables called environment variables that provide various pieces of information for the shell and for programs running within it. 
    - There are a few standard environment variables and you can add others as needed.
    - We can take a look at the current environment variables with `ENV`.
* You can ask for specific variables with "echo" and then variable name starting with a dollar sign. 
    - So for example, we could read out the shell variable with `echo $SHELL`. 
* Script will often read from environment variables in order to learn some information that they need to work with. 
    - You can set environment variables for the current shell: `export MYVAR=hello`.
    - If you need to set up custom environment variables that stick around for all of your Z shell sessions, you can configure them in various configuration files 
* One of the most important environment variables is called `$PATH`, and it sets the locations where the shell will look for commands when you run a command. 
    - Usually the actually command or program we use won't be located in whatever directory you're using, o having common locations set in PATH saves you from typing out the full location of the tool every time you use it. 
    - Again, changes made to the variable interactively will only effect the session where they're made.  
* Z shell has a series of options that can be switched on or off to enable or disable certain features. 
    - These are controlled with the "setopt" and "unsetopt" commands. 
    - Running each of those by themselves will show a list of which options are currently set or enabled or disabled.
* Keep environment variables and options in mind as you use Z shell. To use Z shell, you don't need set or change any of the environment variables or options. 
    - But they're there and knowing how to use them can help make your work in Z shell more efficient.  

### Aliases and Reserved Words

* When we type something in the shell, there's actually a few different kinds of things that the shell might run.
* In order of precedence: 

    1. Aliases
    2. Reserved Words
    3. Functions
    4. Builtins
    5. Commands

* For example, if you want to view hidden files when typing the command `ls`, you can alias it: `alias ls="ls -a"`
    - You can run the actual `ls` command with `command ls`.
* Reserved words are commands in the shell that hold special meaning, generally for use in scripting. 
    - These are things like if, else, various kinds of brackets and braces, and other components of the shell scripting language. 
    - While you can set up aliases using these names, you generally wouldn't want to because it can lead to certain strange situations and weird consequences.  

### Functions

* In Z Shell you can also define and use functions, which are little pieces of script that you can use to compose your own custom functionality.
    - When writing functions, `$1` represents argument variables.
    - You can then remove functions by typing `unfunction ml`.
* You can view all functions in the shell with `functions` by itself.
    - You can load functions that are in the `$FPATH` with `autoload -U functionname`

```zsh
% ml(){
    function> ls -lah $1
    function> }
```
* With this function, you would then write in the Z shell: `ml ~` do use the function on your home directory, for instance.

### Builtins and Commands

* Most of the work we'll do in a shell centers around running commands in order to do something in particular. Many of the regular tools we'll use at the command line are stored in a few directories, like `usrbin` and `bin`. But not all commands we'll use are located here. 
* The shell has a set of commands built into it, and these are called built-ins. 
    - Shells often offer built-ins that do common tasks, so these basic tasks don't have to rely on other programs. 
    - These are different than the command line programs we might use, but they work in a similar way, and in some cases they have the same name as other commands. 
* For example, this is the case with `pwd`, which is both a GNU core tools command and a built-in in Z Shell. 
    - You can see the `pwd` is a built-in by using the `which` built-in, to show where a command resides. 
    - You can then use `command pwd` to use the command version instead of the built-in.
* You can view what commands are built-in with the simple command `enable`. 
    - There's a comprehensive list of the built-ins provided with the shell in `man zshbuiltins`.

## Using Zsh

### Autocd and cd Shorthand

* For the most part, while you're navigating around the file system, you'll be using commands provided by a set of tools available on the system, not specific features of any given shell. Z-Shell provides some helpful built-ins, though.
* An important idea in browsing around the file system, is the concept of the working directory, and that's the directory that you're working or operating inside of. 
    - The first place the shell will look for commands you type, and the location where, if you don't specify a place, files will be created, deleted, or modified in response to a command.
* Z-Shell provides some helpful features that make navigating a little bit easier. One of these is called `autocd`, and it saves you a few keystrokes by letting you type and change to a directory name without the `cd` command if that directory exists. 
    - Autocd is an optional feature, so you need to use the command: `setopt autocd`.
    - Now, to move into a directory, you simply write the directory name, eg. `Documents` instead of `cd Documents`.

### Directory Stacks

* `pushd` works like `cd`, except that in addition to changing the working directory to whatever you set it, it also adds that directory to the directory stack.
    - You can then navigate through this stack, and view the stack with `dirs`, or `dirs -v` to get a numbered stack.
    - You could then navigate through multiple elements of the stack with the command `pushd +2`.
    - Typing `popd` will bring you to the most recent directory in the list, as well as remove the directory you were in previously.
* It can take a bit of practice to make the directory stack part of your workflow, so it's worth spending some time with.
* To create a shortcut for a directory you often use: `hash -d md=~/Documents/mydir`, and then `ls ~md`.
    - Z-shell stores the locations of commands in a file called the hash file for fast retrieval and this hash command works with the entries in that list. 
    - We can view the list with `hash` and if your path variable changes and you need to update the file, you can do that with `rehash`.

### Finding Files and Commands

* On your system, you have some tools to help us find files. One of these is the `find` command, which provides a powerful search mechanism with many options. 
    - `find` isn't unique to the Z shell, but it is very useful. 
    - To use find, we'll type the find command and then provide a path to look in and then we can provide some kind of condition for the search, Eg. `find / -name "pwd" 2>/dev/null` to find any files named "pwd" in the any folder from the root file system. 
    - Eg. `find /home/user -size +5k` will list all files in your home directory larger than 5 kilobytes.
* There's another useful built-in you may want to know about called `whence`. 
    - Whence may sound a little bit Shakespearian but the word means "From what place or source "something comes", and whence helps us understand what a command is and how it would be interpreted when it's used. 
    - There's some overlap between whence and which, as we can see with something straightforward like `which mv` and `whence mv`. 
    - `mv` is a command that lives in the bin directory. Both of these commands show the path to the mv command on the system if there's no alias, function, or built-in with the same name. 
    - For a built-in `which cd` and `whence cd` show a different output. 
    - Remember that whence is showing how a command would be interpreted if it ran, so we just see `cd`. 
    - We can get more verbose information with `whence -v cd`.  
    - Running `whence -f ml` will display the contents of that function.
    - Another useful ability is to use `whence -wm "*"`, which will show everything.
* While finding files is useful, being able to tell how the shell will interpret a command is also helpful, especially for troubleshooting. 

### Auto Complete

* In order to save ourselves a lot of repetitive or tedious typing, Z Shell offers auto completion of commands and paths. You can invoke the auto completion after typing a little bit of a command or path and then pressing TAB. 
    - Auto completion works by a look at what your trying to do and seeing what commands or reasonable paths can be inferred from the information you've provided.
* Auto complete can be pretty helpful. Especially, if you have commands with long names, that you use frequently. 
    - Auto completion also works with paths, not just commands.
* A useful Z shell command is `completeinword`, that needs to be enabled with `setopt completeinword`.
    - This allows you to go in the middle of what you're typing to have autocomplete suggestions for both the beginning *and* end of what you're typing.
* Similarly, there's `correct` (setopt correct), which will autocorrect any mistyped commands or functions.
    - Many people don't like the spelling correction option because they find that it gives them unpredictable or incorrect results.
* In graphical environments you can also drag files or directories onto the terminal window and there paths will be pasted into the Shell. 

### Redirection, Pipes, and Multios

* Redirection, represented by the less than and greater than symbols, change where input to a command comes from, or, where output goes.
    - `<`: Input redirection. `>`: Output redirection 
    - Redirection is useful for making a record of information that would otherwise go to the screen. Or for using a file instead of user generated information as input for a command.
    - Eg. `echo hello > myfile.txt`, or `cat < myfile.txt`
* Each time I redirect to the file, the contents of the file are replaced with whatever I sent. 
    - This is called clobbering because the file gets clobbered, or wiped out each time. You'll notice, there's no warning about it. 
    - Z shell offers an option to prevent this to keep you from accidentally clobbering files. And we can turn that on with `setopt noclobber`.
    - Using `>>` instead of just `>` will append information to a file instead of overwriting it entirely.
* You can also send output from a command to another command with pipes. 
    - Pipes are represented by the pipe, or vertical bar character `|`, and they act as a connection from the output of one command to the input of another. 
    - Using pipes, we can construct commands that use multiple tools, processing output in different ways at each step. 
        - But when we use pipes, we can't see the output that's being sent to the next command. 
    - It can be useful to *tap* into the pipeline and see what's going on at different points. For that, we can use the `tee` command. 
        - Tee acts like a t-shaped pipe fitting, instead of just a straight through or union joint. 
        - It passes along whatever output it gets as an input, and it makes a copy that we can look at, or redirect to a file.
        - Eg. `ls / | tee myfile.txt` will write to that file and also show the contents being written to the file in the command line.
        - Tee doesn't modify anything that passes through it, so it's not really a problem to use it frequently to understand how a pipeline is working.
* The `multios` option in Z shell can be useful if you need to use more than one redirection in a single command.
    - This option performs implicit t's and cats, creating multiple output streams, or using multiple files as input as needed. 
    - Eg. `ls / >file1.txt >file2.txt` will create two identical files.
    - This can be helpful for writing out a command's output to one file, and perhaps appending it to another file, like a journal of activities.
    - The standard input has a descriptor of zero. And the standard output has a descriptor of one. The standard error is two. And we can use these to specify which stream of information we want to send where. 
        - In the shorthand of the shell, `>` implies `1>`.
        - Eg. `find / -name "Doc*" 1>hits.txt 2>errors.txt` will put errors into their own files and make successful output easier to read on its own.


## Customizing Zsh