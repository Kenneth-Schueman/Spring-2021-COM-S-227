package hw1;
/**
 * @author kenschue
 * Model of a printer simulation.
 */
public class Printer
{
	private int max;
	private int pageAmount;
	private int spaceAvailiable;
	private int printAmount;
	private int jobCompletion;
	private int totalPrints;
	private int nextPage;
	private boolean trayRemoved;
	
	
			/**
			* When a printer is create the page amount is initialized to 0, tray set to in printer & set trayCapacity to global variable. 
			*/
			public Printer (int trayCapacity)
			{
			totalPrints = 0;
			pageAmount = 0;
			trayRemoved = false;
			max = trayCapacity;
			}
			
			/**
	 		* I know I wasn't supposed to use conditions but ran out of time, sorry :(
	   		*/
			public void startPrintJob(int documentPages) {
				printAmount = documentPages;
				nextPage = 0;
				
			}
			
			/**
			   *Starts a new print job to make copies of a document that is a specified page length (documentPages). Updates the next page to print as page 0 (denotes the first page of the document).
			   */
			public int getSheetsAvailable() {
				if (trayRemoved == true) 
				{
					return (0);
				}
				return pageAmount;
			}
			
			/**
			   * Returns the next page number of the document that will be printed.
			   */
			public int getNextPage() {
				if (jobCompletion == printAmount) 
				{
					return(0);
				}
				return (nextPage);
			}
				
			
			/**
			   * Returns the count of all pages printed by the printer since its construction.
			   */
			public int getTotalPages() {
				return (totalPrints);
			}
			
			/**
			   * Simulates the printer printing a page
			   */
			public void printPage()
			{
				if (trayRemoved == false) {
					if (pageAmount > 0) {
						++totalPrints;
						++nextPage;
						++jobCompletion;
					}
					--pageAmount;
					if (pageAmount < 0) {
						pageAmount = 0;
					}
				}
			}
			
			/**
			   * Removes the paper tray from the printer; that is, makes the sheets available to the printer zero.
			   */
			public void removeTray() {
				trayRemoved = true;
			}
			
			/**
			   * Replaces the tray in the printer; that is, makes the sheets available to the printer the same as the number of sheets in the tray.
			   */
			public void replaceTray() {
				trayRemoved = false;
			}
			
			/**
			   * Simulates removing the tray, adding the given number of sheets (up to the maximum capacity of the tray), and replacing the tray in the printer.
			   */
			public void addPaper(int sheets) {
				spaceAvailiable = (max - pageAmount); 
				if (sheets > spaceAvailiable) {
					pageAmount = max;
				}
				else {
				pageAmount += sheets;
				}
			}
			
			/**
			   * Simulates removing the tray, removing the given number of sheets (but not allowing the sheets to go below zero), and replacing the tray in the printer.
			   */
			public void removePaper(int sheets) {
				if(sheets > pageAmount) 
				{
					pageAmount = 0;
				}
				
				else 
				{
				pageAmount -= sheets;
				}
			}
	}

