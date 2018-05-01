package Amorblox;

/**
 * Created by kusha on 4/26/2018.
 */
// # We need to process each email in the mailbox of each user in a set of users. In order to
// # process these emails, we first need to fetch each user, and then for each user we need to
// # fetch that user's emails. Once we have fetched the emails we send them downstream for
// # further processing.
// # It would be nice to have a progress bar for this downstream processing. I'd like to
// # know how far along (i.e. percentage) the processing units are in completely processing
// # the total set of emails.
// #
// # e.g.
// # 2 users exist: userA and userB
// # userA has a total of 45 emails, and userB has a total of 55 emails
// # if the downstream processing units have finished 20 emails, the progress bar
// # should read 20% (20 emails processed out of 100 total emails)
// #
// # Emails are fetched and sent downstream in pages of varying length.
// #
// # stages of the problem:
// # 1. determine and output the total number of emails per user
// # 2. determine and output the total number of emails across all users
// # 3. "Process" the emails (more on this when we get here)
// # 4. Check and output the progress of the mail processing as it is happening
// #
// #
// # Assume we've fetched the pages of emails for each user as the following:
// # (format: user - page:count page:count ...)
// # A - 1:20 2:10 3:15
// # B - 1:15 2:10 3:5 4:20 5:5

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Page {
    int pageNumber;
    int size;

    public Page(int pageNumber, int size) {
        this.pageNumber = pageNumber;
        this.size = size;
    }

    public String toString() {
        return "PageNumber: " + pageNumber + " size: " + size;
    }
}

class User {
    String userName;
    List<Page> pages;

    public User(String userName, List<Page> pages) {
        this.userName = userName;
        this.pages = pages;
    }

    public int getEmailCount() {
        int count = 0;
        for (Page page : pages) {
            count += page.size;
        }
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Page page : pages) {
            sb.append("User :" + userName + " " + page.toString() + "\n");
        }
        return sb.toString();
    }
}


public class EmailParser {
    HashMap<String, User> userMap = new HashMap();
    int totalEmails;

    public EmailParser(List<User> userList) {
        for (User user : userList) {
            userMap.put(user.userName, user);
        }
    }

    public static void main(String[] args) {
        List<Page> pagesUserA = new ArrayList();
        pagesUserA.add(new Page(1, 20));
        pagesUserA.add(new Page(2, 10));
        pagesUserA.add(new Page(3, 15));
        List<Page> pagesUserB = new ArrayList();
        pagesUserB.add(new Page(1, 15));
        pagesUserB.add(new Page(2, 10));
        pagesUserB.add(new Page(3, 5));
        pagesUserB.add(new Page(4, 20));
        pagesUserB.add(new Page(5, 5));
        User A = new User("A", pagesUserA);
        User B = new User("B", pagesUserB);
        List users = new ArrayList();
        users.add(A);
        users.add(B);
        EmailParser sol = new EmailParser(users);
        sol.bfs();

    }

    public int numberOfEmails() {
        int count = 0;
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            User user = entry.getValue();
            int userEmailCount = user.getEmailCount();
            System.out.println(user.toString());
            System.out.println("Username: " + user.userName + " UserEmailCount:" + userEmailCount);
            count += userEmailCount;
        }
        return count;
    }

    public void bfs() {
        boolean hasMore = false;
        HashMap<String, int[]> map = new HashMap<>();
        totalEmails = numberOfEmails();
        int currentCount = 0;
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            map.put(entry.getKey(), new int[]{0, 0});
        }
        do {
            hasMore = false;
            for (Map.Entry<String, User> entry : userMap.entrySet()) {
                User user = entry.getValue();
                int vals[] = map.get(user.userName);
                if (vals[0] >= user.pages.size()) {
                    continue;
                }
                currentCount++;
                System.out.println("User :" + user.userName + " processing page:" + vals[0] + " emailNumber:" + vals[1] + " " + (currentCount * 100 / totalEmails));
                hasMore = true;
                vals[1]++;
                if (vals[1] >= user.pages.get(vals[0]).size) {
                    vals[1] = 0;
                    vals[0]++;
                }

            }
        } while (hasMore);
    }
}


/*
Your previous Plain Text content is preserved below:



 */