package general;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LRU_Cache_Priority_Queue {
	private PriorityQueue<LRUPage> priorityQueue = new PriorityQueue<LRUPage>(3, new LRUPageComparator());

	public static void main(String[] args) throws InterruptedException {

		System.out.println(" Pages for consideration : 2, 1, 0, 2, 8, 2, 4");
		System.out.println("----------------------------------------------\n");

		LRU_Cache_Priority_Queue cache = new LRU_Cache_Priority_Queue();
		cache.addPageToQueue(new LRUPage("2"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("1"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("0"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("2"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("8"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("2"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("4"));
		Thread.sleep(100);

		System.out.println("\nLRUCache Pages");
		System.out.println("-------------");
		cache.displayPriorityQueue();
	}

	public synchronized void addPageToQueue(LRUPage page) {
		boolean pageExists = false;
		if (priorityQueue.size() == 3) {
			Iterator<LRUPage> iterator = priorityQueue.iterator();

			while (iterator.hasNext()) {
				LRUPage next = iterator.next();
				if (next.getPageName().equals(page.getPageName())) {
					/*
					 * wanted to just change the time, so that no need to poll
					 * and add again. but elements ordering does not happen, it
					 * happens only at the time of adding to the queue
					 * 
					 * In case somebody finds it, plz let me know.
					 */
					// next.setPageCreationTime(page.getPageCreationTime());

					priorityQueue.remove(next);
					System.out
							.println("Page: "
									+ page.getPageName()
									+ " already exisit in cache. Last accessed time updated");
					pageExists = true;
					break;
				}
			}
			if (!pageExists) {
				// enable it for printing the queue elemnts
				// System.out.println(priorityQueue);
				LRUPage poll = priorityQueue.poll();
				System.out.println("Page Fault, PAGE: " + poll.getPageName()
						+ ", Replaced with PAGE: " + page.getPageName());

			}
		}
		if (!pageExists) {
			System.out.println("Page added into cache is : "
					+ page.getPageName());
		}
		priorityQueue.add(page);

	}

	public void displayPriorityQueue() {
		Iterator<LRUPage> iterator = priorityQueue.iterator();
		while (iterator.hasNext()) {
			LRUPage next = iterator.next();
			System.out.println(next);
		}
	}
}

class LRUPage {
	private String pageName;
	private long pageCreationTime;

	public LRUPage(String pagename) {
		this.pageName = pagename;
		this.pageCreationTime = System.currentTimeMillis();
	}

	public String getPageName() {
		return pageName;
	}

	public long getPageCreationTime() {
		return pageCreationTime;
	}

	public void setPageCreationTime(long pageCreationTime) {
		this.pageCreationTime = pageCreationTime;
	}

	@Override
	public boolean equals(Object obj) {
		LRUPage page = (LRUPage) obj;
		if (pageCreationTime == page.pageCreationTime) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (int) (31 * pageCreationTime);
	}

	@Override
	public String toString() {
		return "PageName: " + pageName + ", PageCreationTime: "
				+ pageCreationTime;
	}
}

class LRUPageComparator implements Comparator<LRUPage> {

	@Override
	public int compare(LRUPage o1, LRUPage o2) {
		if (o1.getPageCreationTime() > o2.getPageCreationTime()) {
			return 1;
		}
		if (o1.getPageCreationTime() < o2.getPageCreationTime()) {
			return -1;
		}
		return 0;
	}
}
