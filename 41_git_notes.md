----------------
Git
----------------

- Git is an open source ***version control system***

- I use Git professionally, on a daily basis.
- On large projects, often multiple people are working on the same files / same codebase, so you want to be able to manage the code updates that multiple people are making at the same time
- [Here's a link to some Git documentation](https://www.git-scm.com/book/en/v2/Getting-Started-What-is-Git%3F)

## Repositories

- A repository is a collection of related files, that git is tracking.
- You have been utilizing repositories for each of your assignments and labs throughout the semester.
- I hope at this point, you've gotten to see first hand some of the benefits of git.

- For us, our repositories have been made up of a collection of:
1. code 
2. associated files, such as:
	- README.md
	- screenshots
	- documentation
	- test files
	- unit tests, and so on

- It could also be non-code related files, such as requirements, as long as there is a way to show differences between files in a meaningful way.
	- For the simple scope of each assignment, this was typically captured in the `README.md` file that you have become aquainted yet.
	- Typically, markdown files (those ending in md) can be used to present information pertinent to the contents of the repository.

- [Here is a cheat sheet for markdown. (Which I used throughout the semester to build up the majority of the lecture notes.)](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

## Creating a git repository from scratch (Locally first)

Throughout the semester, when you accept an assignment, typically a git hub repository is created for you automatically, and associated with your github account.

- It is also possible to create a repository from scratch

1. Let's make a new directory
2. Copy some code into it
3. Cd into the directory

We can make it a repository by executing the `git init` command.


``` bash 
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last$ mkdir test
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last$ cd test
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ ls
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git init
Initialized empty Git repository in /home/shawn-bailey/teaching/fall-2022/cs140/lecture_notes/last/test/.git/
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git status
On branch master

No commits yet

nothing to commit (create/copy files and use "git add" to track)

```

## Adding files to the repository

As you already know, we can execute `git add *.java` which adds all files ending with the java file name extension to be tracked.

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
	new file:   A.java
	new file:   B.java
	new file:   C.java
	new file:   D.java

```
- `git status` shows git knows about my java files, but they aren't committed into the repository yet.
- The files are “staged” to be committed

## Committing files to the repository

- As you already know, execute `git commit -m "Some Commit Message"`
- Executing `git log` logs all the commits we have made thus far. 

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git commit -m "adding files A,B,C,D"
[master (root-commit) 2661f69] adding files A,B,C,D
 4 files changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 A.java
 create mode 100644 B.java
 create mode 100644 C.java
 create mode 100644 D.java
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git status
On branch master
nothing to commit, working tree clean
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git log
commit 2661f69757f9002db73cd3de797aea1b7310d460 (HEAD -> master)
Author: Shawn Bailey <sbailey6@binghamton.edu>
Date:   Sun Dec 4 21:25:21 2022 -0500

    adding files A,B,C,D

```

## Peeking at our remote settings

We can run the following to see if we are pointing to some remote location on github:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git remote -v
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ 
```

Currently, we are not. Let's fix that.

## Adding the local repo to github

To put the local repo on github, we first need to make an empty repository on the github side. Doing so results in the following:

![0](./pngs/git/empty_repo.png)

We have created an existing repo already, so we opt for the later suggestion:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git remote add origin git@github.com:Binghamton-University-CS140-Fall-2022/test.git
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git branch -M main
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git push -u origin main
Enumerating objects: 3, done.
Counting objects: 100% (3/3), done.
Delta compression using up to 4 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 237 bytes | 237.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0)
To github.com:Binghamton-University-CS140-Fall-2022/test.git
 * [new branch]      main -> main
Branch 'main' set up to track remote branch 'main' from 'origin'.
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git remote -v
origin	git@github.com:Binghamton-University-CS140-Fall-2022/test.git (fetch)
origin	git@github.com:Binghamton-University-CS140-Fall-2022/test.git (push)
```

## Collaboration 

### Dealing with Merge Conflicts

Let's showcase a simple example of how multiple developers could utilize git to deal with the same files being editted by multiple people.
Typically, this leads to what is known as a ***merge conflict***.

A ***merge conflict*** needs to be resolved by the developer dealing with the issue.

## Developer 1 does some stuff 

Suppose developer 1 starts working on `A.java` and does the following changes:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test_other$ vi A.java
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test_other$ git status
On branch main
Your branch is up to date with 'origin/main'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
	modified:   A.java

no changes added to commit (use "git add" and/or "git commit -a")
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test_other$ git add -A
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test_other$ git commit -m "dev 1: adding summation"
[main d0d1402] dev 1: adding summation
 1 file changed, 16 insertions(+)
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test_other$ git push origin
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 4 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 386 bytes | 386.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0)
To github.com:Binghamton-University-CS140-Fall-2022/test.git
   2661f69..d0d1402  main -> main
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test_other$ git diff HEAD^
diff --git a/A.java b/A.java
index e69de29..f3a39e8 100644
--- a/A.java
+++ b/A.java
@@ -0,0 +1,16 @@
+class A
+{
+       protected int a;
+       protected int b;
+
+       public A(int a, int b)
+       {
+               this.a = a;
+               this.b = b;
+       }
+
+       public int foo()
+       {
+               return a - b;
+       }
+}
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140
```

**Note:** `HEAD^` is shorthand notation that says, we want to see the difference to one commit that is previous to our current commit. The current commit is represented by `HEAD`

This is why, when we run `git rev-parse HEAD` we get the commit hash of our last commit created.

## Developer 2

If you are working on a project with multiple people, you need to periodically check whether one of your coworkers has made changes.
We can do that via the `git fetch` command:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git status
On branch main
Your branch is up to date with 'origin/main'.

nothing to commit, working tree clean
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git fetch --all
Fetching origin
remote: Enumerating objects: 5, done.
remote: Counting objects: 100% (5/5), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 3 (delta 0), reused 3 (delta 0), pack-reused 0
Unpacking objects: 100% (3/3), 366 bytes | 366.00 KiB/s, done.
From github.com:Binghamton-University-CS140-Fall-2022/test
   2661f69..d0d1402  main       -> origin/main
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git status
On branch main
Your branch is behind 'origin/main' by 1 commit, and can be fast-forwarded.
  (use "git pull" to update your local branch)

nothing to commit, working tree clean

```

Developer 2 sees that work has been done, someone has committed to the remote repo, and their local version of the repo is behind.

Now, suppose the developer also makes an edit to `A.java`

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ vi A.java
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git status
On branch main
Your branch is behind 'origin/main' by 1 commit, and can be fast-forwarded.
  (use "git pull" to update your local branch)

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
	modified:   A.java

no changes added to commit (use "git add" and/or "git commit -a")
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git diff
diff --git a/A.java b/A.java
index e69de29..d7e23cb 100644
--- a/A.java
+++ b/A.java
@@ -0,0 +1,13 @@
+//Dev 2 made a different implementation entirely...
+class A
+{
+       public A()
+       {
+
+       }
+
+       public static int diff(int x, int y)
+       {
+               return x - y;
+       }
+}
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ 
```

As you can see from the diff, developer 2 did different stuff in `A.java` than developer 1.
Let's see what happens when we try to pull now.

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git pull origin
Updating 2661f69..d0d1402
error: Your local changes to the following files would be overwritten by merge:
	A.java
Please commit your changes or stash them before you merge.
Aborting
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ 
```

We can't pull, because that would overwrite changes we have in A.java.
Surely we can fix this by simply comitting and pulling, right?

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git commit -m "dev 2: adding class A implementations"
[main 05260c3] dev 2: adding class A implementations
 1 file changed, 13 insertions(+)
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git status
On branch main
Your branch and 'origin/main' have diverged,
and have 1 and 1 different commits each, respectively.
  (use "git pull" to merge the remote branch into yours)

nothing to commit, working tree clean
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git pull origin
Auto-merging A.java
CONFLICT (content): Merge conflict in A.java
Automatic merge failed; fix conflicts and then commit the result.
```

Notice, we have some complications here. First, our branch is considered to have ***diverged***. We are one commit ahead, while also one commit behind.
When we try to pull, we see that we get a merge conflict.

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git status
On branch main
Your branch and 'origin/main' have diverged,
and have 1 and 1 different commits each, respectively.
  (use "git pull" to merge the remote branch into yours)

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   A.java

no changes added to commit (use "git add" and/or "git commit -a")

```

Doing a `git status` shows that we **both** modified the file.

## Resolving the merge conflict

So, who is right? What should we keep. Dev 1's changes, or dev 2's changes? What about a combination of both?

This is all subjective, and should be handled on a case by case basis. 

Typically, when working with a team, you might implement some piece of code months ago, and then a new requirement is brought to your attention later on, at which point that code needs to be editted.
You might end up in situations where each of you are working a separate feature, but are touching similar files.

Point being, merge conflicts are a necessary headache that needs to be dealt with some times.

But what does a merge conflict look like?

Here is what Dev 2's file looks like while dealing with the merge conflict:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git diff
diff --cc A.java
index d7e23cb,f3a39e8..0000000
--- a/A.java
+++ b/A.java
@@@ -1,13 -1,16 +1,30 @@@
++<<<<<<< HEAD
 +//Dev 2 made a different implementation entirely...
 +class A
 +{
 +      public A()
 +      {
 +
 +      }
 +
 +      public static int diff(int x, int y)
 +      {
 +              return x - y;
++=======
+ class A
+ {
+       protected int a;
+       protected int b;
+ 
+       public A(int a, int b)
+       {
+               this.a = a;
+               this.b = b;
+       }
+ 
+       public int foo()
+       {
+               return a - b;
++>>>>>>> d0d14029cd87c4756542f6768a1556ff269fc6c8
        }
  }
```


Here is Dev 1's log:

```
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ cd ../test_other
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test_other$ git log
commit d0d14029cd87c4756542f6768a1556ff269fc6c8 (HEAD -> main, origin/main, origin/HEAD)
Author: Shawn Bailey <sbailey6@binghamton.edu>
Date:   Sun Dec 4 22:10:06 2022 -0500

    dev 1: adding summation

commit 2661f69757f9002db73cd3de797aea1b7310d460
Author: Shawn Bailey <sbailey6@binghamton.edu>
Date:   Sun Dec 4 21:25:21 2022 -0500

    adding files A,B,C,D
```

Note that the commit that was produced when Dev 1 pushed up is showing up in Dev 2's `A.java` file.

Also, there is some way git denotes the changes both developers made:

``` bash
<<<<<<<<<< HEAD

MY CODE 

==========

THEIR CODE

>>>>>>>>>>>>>>>> SOME COMMIT HASH
```

We can see that this section of code is considered a conflict. Note that one file can have multiple sections like this.
In our case, let's assume we want to keep both implementation details made by each engineer.

We can touch up the code to keep their code and our code, with the merge markings removed:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git add -A
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git commit -m "dealt with merge conflicts"
[main aa4a475] dealt with merge conflicts
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git status
On branch main
Your branch is ahead of 'origin/main' by 2 commits.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ git push origin
Enumerating objects: 10, done.
Counting objects: 100% (10/10), done.
Delta compression using up to 4 threads
Compressing objects: 100% (6/6), done.
Writing objects: 100% (6/6), 778 bytes | 778.00 KiB/s, done.
Total 6 (delta 1), reused 0 (delta 0)
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To github.com:Binghamton-University-CS140-Fall-2022/test.git
   d0d1402..aa4a475  main -> main
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/last/test$ cat A.java
class A
{
	protected int a;
	protected int b;

	public A(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	public static int diff(int x, int y)
	{
		return x - y;
	

	public int foo()
	{
		return a - b;
	}
}
```

## Some Bonus info

### Ability to make multiple branches

- High level, git can be used to create multiple branches that are being maintained simulatenously by different developers.
- Question: Why is this useful?

- We can create a branch per feature being worked.
	- While working the feature, we aren't breaking the master branch
	- We don't have to deal with causing merge conflicts for others
	- We can work independently and not step on another developer's toes
- When the feature is done, we can make a **pull request**
	- Typically, this involves all team members reviewing your code
	- Typically, there will be some automated process to:
		- Build your production code
		- Build your test code
		- Ensure that all compiles
		- Ensure all tests pass that have been written
	- If the code looks good and no one raises any concerns, it can be merged into the master branch if it successfully builds and passes tests
- Once the feature is merged in, it's part of the master baseline.
	- Other developers can pull in that change to their branches, get your new feature that they can leverage.
	- They can deal with their merge conflicts that arise, and continue working 

## Conclusion

Git, and version control in general is a very powerful tool. There are many other caveats and details, but they are beyond the scope for now.
I just wanted to give you a high level idea of some scenarios you'll typically encounter in a software development setting.
