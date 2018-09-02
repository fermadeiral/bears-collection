import os
import subprocess
import json

REPO_NAME = "bears-benchmark-fer"
GIT_DIR = os.path.join("home", "fernanda", "git", REPO_NAME)

# read branch names from a .txt file
PATH_TO_BRANCH_NAMES = os.path.join('/', "home", "fernanda", "branches.txt")
branches = []
with open(PATH_TO_BRANCH_NAMES, "r") as f:
    for line in f:
        branches.append(line)

print "%d branches found." % len(branches)

bugs = []
for branch in branches:
    print "Branch: %s" % branch

    cmd = "cd /%s; git checkout %s;" % (GIT_DIR, branch)
    subprocess.call(cmd, shell=True)

    cmd = "cd /%s; git rev-parse HEAD~2;" % GIT_DIR
    buggy_commit = subprocess.check_output(cmd, shell=True).replace("\n", "")
    print buggy_commit

    cmd = "cd /%s; git rev-parse HEAD~1;" % GIT_DIR
    fixed_commit = subprocess.check_output(cmd, shell=True).replace("\n", "")
    print fixed_commit

    cmd = "cd /%s; git diff %s %s -- '*.java';" % (GIT_DIR, buggy_commit, fixed_commit)
    human_patch = subprocess.check_output(cmd, shell=True)

    with open(os.path.join('/', GIT_DIR, 'bears.json')) as original_json_file:
        bug = json.load(original_json_file)
        bug['repository']['name'] = bug['repository']['name'].replace("/","-")
        bug['branchUrl'] = "https://github.com/fermadeiral/" + REPO_NAME + "/tree/" + branch
        bug['diff'] = human_patch
        bugs += [bug]

    print "Processed %d bugs" % len(bugs)

with open(os.path.join('/home', "fernanda", "git", "bears-collection", "docs", "data", "bears-bugs.json"), "w") as fd:
    json.dump(bugs, fd, indent=2)
