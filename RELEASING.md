Releasing
=========
When a release branch is ready to be merged into master and in turn deployed to the Play Store. In the release branch:
1. Update [CHANGELOG.md](../CHANGELOG.md)
  * Add title with the release `versionName`
  * Add list of commits since last release in date descending order, not including any merge commits or release notes related commits
2. Update listing [metadata](../app/src/main/play/en-GB/whatsnew-internal) with what was added to `CHANGELOG.md`
3. Commit changes `git commit -am '{versionName} release notes'`
4. Create a PR into master, review, merge and close the old release branch if all is OK

Prepare the next release branch
-------------------------------
5. Checkout master and reset to 'origin/master'
  * 'git checkout master && git fetch && git reset --hard origin/master'
6. Bump `versionName` in `app/build.gradle`

NOTE: Steps 7-9 can be run with './gradlew prepareNextRelease'
7. Create a new release branch `git checkout -b release-{versionName}`
8. Update previous `CHANGELOG.md` entry to append title with the build commit of that release
9. Commit changes `git commit -am 'bump version to {versionName}'`
10. Tag and push
  * If the build was a public release tag its build commit `git tag -a {versionName} {previous merge commit}`
  * Push it `git push && git push --tags`
11. Branch off here to work on feature relevant to this release