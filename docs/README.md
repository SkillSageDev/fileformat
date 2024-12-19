# FileFormat
 prints all values of any type of file formats
The project structure is as follows:
	Calculators: takes a bits and find it is value.
	Parses: gets the value from calculators and stores it.
	Printer: display the values.
	Reader: read the file bytes and gets the header bytes.
	Checker: check the file type from the header bytes.
Utilities:
	Extractor: extracts a specific bits from a sequence of bytes.
	ByteMerger: merge the bytes together.
Each component implements an interface only extractor that has no interface to implement from.

I tried to implement the solid principles and learn maven while doing the project that’s why it is too long, and I don't think I did that good job but I learned a lot.	
