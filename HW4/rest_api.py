import sys
from collections import defaultdict
import json
import requests

# Get github access token key.
def get_github_key():
    f = open("github.key", "r")
    key = f.read()
    key = key.rstrip("\n\r")

    return key

# Task 1.1
def list_all_branches():
    repo_path = input('Input repo path in this format: username/repo_name: ')
    resp = requests.get('https://api.github.com/repos/{}/branches'.format(repo_path))
    list_of_branches = []

    if resp.status_code != 200:
        # Something went wrong.
        print('API Error!: {}'.format(resp.status_code))
    for item in resp.json():
        list_of_branches.append(item['name'])

    print(list_of_branches)

# Task 1.2
def create_repo():
    key = get_github_key()
    repo_name = input('Enter your repository name: ')
    repo_desc = input('Enter a description of your repository: ')
    private = input('Choose\n1. Private\n2. Public: ')
    private_bool = True if private == '1' else False
    data = {
      "name": repo_name,
      "description": repo_desc,
      "homepage": "https://github.com",
      "private": private_bool,
      "has_issues": True,
      "has_projects": True,
      "has_wiki": True,
    }
    payload = json.dumps(data)
    url = "https://api.github.com/user/repos"
    resp = requests.post(url, data=payload, headers={"authorization": "token " + key})
    if resp.status_code != 201:
        # Something went wrong.
        print('API Error!: {}'.format(resp.status_code))
    else:
        print('Success')

# Task 1.3
def create_issue():
    key = get_github_key()
    owner_name = input('Enter the name of repo owner: ')
    repo_name = input('Enter repo name: ')
    issue_name = input('Enter issue title: ')
    issue_desc = input('Enter a description of issue: ')
    data = {
      "title": issue_name,
      "body": issue_desc,
    }
    payload = json.dumps(data)
    url = "https://api.github.com/repos/{}/{}/issues".format(owner_name, repo_name)
    resp = requests.post(url, data=payload, headers={"authorization": "token " + key})
    if resp.status_code != 201:
        # Something went wrong.
        print('API Error!: {}'.format(resp.status_code))
    else:
        print('Success')

# Task 1.4
def add_an_assignee():
    key = get_github_key()
    owner_name = input('Enter the name of repo owner: ')
    repo_name = input('Enter repo name: ')
    issue_number = input('Enter issue number: ')
    assignee = input('Enter the username of assignee: ')
    data = {
      "assignees": [assignee],
    }
    payload = json.dumps(data)
    url = "https://api.github.com/repos/{}/{}/issues/{}/assignees".format(owner_name, repo_name, issue_number)
    resp = requests.post(url, data=payload, headers={"authorization": "token " + key})
    if resp.status_code != 201:
        # Something went wrong.
        print('API Error!: {}'.format(resp.status_code))
    else:
        print('Success')

# Task 1.5
def edit_a_repo():
    key = get_github_key()
    owner_name = input('Enter the name of repo owner: ')
    repo_name = input('Enter repo name: ')
    data = {
      "name": repo_name,
      "homepage": "https://github.com",
      "has_issues": False,
      "has_projects": True,
      "has_wiki": True
    }
    payload = json.dumps(data)
    url = "https://api.github.com/repos/{}/{}".format(owner_name, repo_name)
    resp = requests.post(url, data=payload, headers={"authorization": "token " + key})
    if resp.status_code != 200:
        # Something went wrong.
        print('API Error!: {}'.format(resp.status_code))
    else:
        print('Successfully disabled issues.')

# Task 1.6
def list_a_reactions():
    key = get_github_key()
    owner_name = input('Enter the name of repo owner: ')
    repo_name = input('Enter repo name: ')
    issue_number = input('Enter issue number: ')
    url = "https://api.github.com/repos/{}/{}/issues/{}/reactions".format(owner_name, repo_name, issue_number)
    resp = requests.get(url, headers={"authorization": "token " + key, "Accept": "application/vnd.github.squirrel-girl-preview+json"})
    if resp.status_code != 200:
        # Something went wrong.
        print('API Error!: {}'.format(resp.status_code))
    else:
        print(resp.json())

# Main driver function.
def main():
    intiator_promp = """Please select one of the following options:\n
    1. List branches\n
    2. Create repository\n
    3. Create issue\n
    4. Add an assignee\n
    5. Edit a repository\n
    6. List reactions\n
    """
    option = input(intiator_promp)

    if option == '1':
        # 1. Get list of branches from github.
        list_all_branches()
    elif option == '2':
        # 2. Create a new repository.
        create_repo()
    elif option == '3':
        # 3. Create issue.
        create_issue()
    elif option == '4':
        # 4. Add an assignee.
        add_an_assignee()
    elif option == '5':
        # 5. Edit a repo.
        edit_a_repo()
    elif option == '6':
        # 6. List a reaction.
        list_a_reactions()
    else:
        print('Please select a valid option!!!')

    return 0

# Trigger main driver function.
if __name__ == '__main__':
    main()
