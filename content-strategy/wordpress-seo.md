# Advanced WordPress SEO

**Table of Contents:**

- [Advanced WordPress SEO](#advanced-wordpress-seo)
  - [Search Engine Optimization for Wordpress](#search-engine-optimization-for-wordpress)
  - [Website Architecutre](#website-architecutre)
  - [Technical Tools](#technical-tools)
    - [Web Crawler](#web-crawler)
    - [Merkle](#merkle)
    - [Google Search Console](#google-search-console)
  - [SEO Plugins](#seo-plugins)
    - [All-in-One SEO](#all-in-one-seo)
    - [Yoast SEO](#yoast-seo)
    - [Rank Math](#rank-math)
  - [Crawling a Website](#crawling-a-website)
    - [Page Titles and Descriptions](#page-titles-and-descriptions)
    - [Heading Tags](#heading-tags)
  - [Managing Architecture](#managing-architecture)
    - [Permalink Best Practices](#permalink-best-practices)
    - [HTTPS Status Codes](#https-status-codes)
    - [Modifying Existing Links](#modifying-existing-links)
    - [Changing Permalink Structure](#changing-permalink-structure)
  - [HTTP vs. HTTPS](#http-vs-https)
    - [Migration to HTTPS](#migration-to-https)
  - [Robots and Sitemaps](#robots-and-sitemaps)
    - [Robots.txtvv](#robotstxtvv)
    - [Sitemaps](#sitemaps)

## Search Engine Optimization for Wordpress

- Most everyone doing SEO understands it pretty well: Find a topic that people are searching for and produce content that's better or has a fresher perspective. 
  - But all of that content, well, that's just the bait on the end of your fishing line. 
  - You can have the best bait, if you're fishing with a shoe-string and a stick, well, you're in for a bad day. 
- If you want to compete, you want the best fishing rod, reel, line, and the knowledge on where and when to fish. 
  - An SEO-friendly WordPress site is in some ways like your fishing rod. 
  - It's the technical foundation for everything you're going to do in your SEO efforts. 
- When you develop a highly optimized website, you make it easy for search engines to access your content and understand it. 
  - An optimized website adheres to both the written and unwritten rules. 
  - Everything from the user experience to the organization of the content to the page speed plays a significant role in where you rank. 
- Build a highly optimized website and you'll gain a real competitive advantage. 
  - This optimization however, is a serious departure from content development. 
  - This means looking at indexability, root domains, redirects, canonical URLs, page tag structured data, and even critical rendering paths. 
- The goal is to find the right balance because truthfully, a website that's really good for users is really good for SEO. 
  - Keep in mind there's no silver bullet here. 
  - You need to embrace as many of these elements as possible. 
  - At the very least, improve them beyond what your competition is doing. N
  - obody maintains top positions forever though, so you'll have to stay vigilant.

## Website Architecutre

- A well optimized site will have a thoughtful approach to information architecture. 
  - Google needs to understand what content is most important to your visitors. 
  - And the way you decide to organize your site sends a signal to Google on what is and what isn't important. 
  - A logical and properly constructed site architecture makes your goals very clear to Google, but also very helpful to your visitors. 
- A common rule-of-thumb is to keep all your prominent content no more than just four clicks away.
- You might notice that URL structure doesn't always match the actual categories that are applied in bread crumbs. And that's okay. 
  - While historically, the actual URL structure was important, given the ability the ability to mark up our site with structured data, we have the opportunity to indicate to Google that this URL is applicable to these bread crumbs. And it helps assign an understanding of that site architecture. 

## Technical Tools

- Google Chrome has many baked-in features that help with SEO, including their Lighthouse audit and developer tools.

### Web Crawler

- The process of Google and other search engines evaluating your site is done through what's known as the crawl. 
  - A bot will arrive on your site, click on all of your links, and hopefully index your content. 
  - But the truth is, we don't have a lot of insight into what's going on when Google and others crawl your site. 
- Fortunately there's a tool called Screaming Frog SEO Spider that will run on your PC, Mac or even Linux machines and crawl your site just as a search engine would. 
  - You'll find it at [screamingfrog.co.uk](screamingfrog.co.uk). 
  - The ability to automate a crawl and quickly identify problems is invaluable

### Merkle

- One of the main aspects of managing technical SEO is all of the testing that has to happen, and there is a great resource at technicalseo.com, and it's provided by Merkle. 
  - There, they've aggregated a variety of the most popular tests that you'll be using to manage your technical SEO, things like testing your robots.txt file, managing your fetch and render, looking at schema, evaluating how your search results look, and so on. 
- Each of these tools is relatively easy to use. Simply select the tool, and follow the prompts on the screen. 
  - Go ahead and start using these tools on your own and identifying what type of interesting insights you might uncover.

### Google Search Console

- Google Search Console is a free service offered by Google the helps you monitor and maintain your site's presence in Google search results. 
  - It is incredibly powerful and it gives you all kinds of useful information, such as what pages of your site have errors, how people are searching for your content, if your sitemaps are working, and so on and so forth. 
- Google Search Console should be part of every technical SEO toolkit. 
  - It gives you such rich insights as what's going on under the hood that it's imperative that you have it installed and set up. 
  - There are a ton of great resources right here that can walk you though in depth how to use it and how to leverage it for your technical SEO.

## SEO Plugins

- SEO plugins for WordPress are both a blessing and a curse. 
  - There is an endless amount of plugins available and it's relatively easy to find an SEO problem that can be solved with a plugin. 
  - The problem is that plugins add to the overall bloat of WordPress. And one of the biggest complaints of WordPress is that it can get really bloated, really quickly, which can ironically negatively impact your SEO. 
- Every plugin has its own features, and JavaScript, and options, and elements, that can change how quickly your site loads, how it renders, and there's always the likelihood that plugins negatively impact one another. 
  - They may have conflicts. So every time you're faced with an SEO problem, I encourage you, to evaluate whether you really need a plugin or not. 
  - Most of what these plugins do, can be handled and managed manually. 
  - And it's important to evaluate whether you're simply trying to save time or whether this plugin really does fundamentally shift your SEO in a positive direction. 
- It's important that you don't get into a mindset of over-using plugins. Think lean when it comes to your plugin use, as that will result, in an overall lighter and faster WordPress instance.

### All-in-One SEO

- When it comes to managing your technical WordPress SEO, just about every site is going to benefit from what I call a quote, unquote, "do-it-all" style plugin. 
  - These plugins manage the most common SEO functionality, giving you the ability to quickly influence most of the technical aspects of your SEO. 
  - There are three tools that are most popularly installed for this purpose. 
- The first is Yoast SEO, which is by far the most installed WordPress SEO plugin. 
- The second is RankMath, and this is a newer entrant to the market, and it's becoming incredibly popular. 
- And finally, there's the All in One SEO Pack, which is billed as the original WordPress SEO plugin, and is also still incredibly popular. 
- Now, each of these tools has its pros and cons, and it is a hotly debated topic. 
  - Visit each of these plugin's websites and evaluate what they do, read the reviews, and evaluate how it fits in to your technical SEO needs.\

### Yoast SEO

- One of the most popular options is Yoast SEO. It gives you ton of flexibility over your sites content, how you manage your meta descriptions, and even a way to build out your schema and sitemaps. 
  - Yoast is really focused on being friendly to beginners and most of its advanced functionality is tucked away in a menu.
- One thing that Yoast tries to do is analyze the content within each article that you're developing from an SEO perspective. 
  - You're supposed to select a keyphrase. Say, "marketing", and then it's going to evaluate how you're doing. 
  - And this is where Yoast becomes hotly debated. A lot of the suggestions Yoast makes here is relatively outdated.
- That said, it does provide great out-of-the-box functionality. 
  - It's incredibly easy-to-use for a new user. 
  - There is a tremendously large and supportive community with lots of help articles. 
  - So that can make it a pro if you're interested in just starting out with a new SEO tool. 
- But there are other SEO tools that can do everything Yoast does, but a little bit simpler.

### Rank Math

- Rank Math is a relatively new plugin. 
  - It's free and done a tremendous job of creating all of the great SEO functionality with very little bloat.
- One of the areas that I like most about this tool is it's ability to manage all of the rich snippets, which I find to be incredibly valuable in moving the needle with your technical SEO.

## Crawling a Website

- Start every SEO project by crawling the site, and use something like Screaming Frog SEO Crawler to do just that. 
  - This tool allow you to quickly identify how the site's structured, all of the meta descriptions, meta keywords, what heading tags are being used, and so on.
- This is where we start to begin our true technical audit. 
  - You can start by evaluating anything that's been blocked by robots.txt. This is helpful in understanding if our content is not going to be indexed by Google. 
  - You can see all of our redirections, we could see if we had any 404 errors that needed to be resolved. 
  - You can see if we have issues with our URLs, and then, our page titles. 
- See where we have duplicate page titles, short page titles, long page titles, and so on. Each of these areas represents something that we'd like to review and evaluate. 
  - This tool provides a ton of incredible resources, so I encourage you to evaluate your own site using it, and see what you discover.

### Page Titles and Descriptions

-  It's important that every page title is unique, clearly named, and relevant to the content on the page.
-  Eg. Look at SERP Snippets, which will display what the listings from the website look like in Google search results.
   - The components within the search results are your title tag, your URL and then the meta description. 
   - Google doesn't always take the meta description that you provide, oftentimes it generates its own using the content on your site. 
- But you can guide it by using that meta description, think of these components as working together to create an advertisement, and we really want that headline to be captivating and draw visitors to click on our website. 
  - We also know from foundational SEO that any keyword that someone types into Google is going to be bolded in that title, so it's important that our foundational keywords are added as well
- First review any duplicate page titles. 
  - It's important from an SEO perspective that all page titles are unique/
- Second, review any short page titles. 
  - This is not necessarily a bad thing, but it's an indication to me that there might not be enough context, and given that Google gives us room to add that information we might as well use it. 
  - You should also review titles that are either over 65 characters or over 568 pixels (maximum length).
- It's important that each page has a unique meta description. 
  - Google often uses the meta description as the short text which is visible in the search results.
  - An example of this might be: *This amazing recipe for %title% is spiced only with Salt. You've come to the right place if you're looking for %tags%*.
- Go through each of the pages that exist on your site and make sure that you have a custom meta description for each. 
  - If you're operating a very large site take advantage of programmatically generating your meta descriptions so they're all uniquely different and then hand pick the ones that are most important to tweak even further to give it that personalized touch.

### Heading Tags

- An important aspect of the technical structure of your WordPress website is your use of heading tags. 
  - These tags, known as H1, H2, H3, and so on help Google understand the importance of the content on your page. 
- You always want your heading tags to appear in order on your page and you should only ever have one heading tag. 
- And you also want to make sure that you avoid using your heading one tag to say things like *about us*, or *contact us*. 
  - Instead, you want to focus on the core topic for the page.
- Similarly, look at the heading two `<h2>` tag, which should reference the second most important topical item on the page.
- By default, Word Press will take any article title and make it a heading one.  By default, Word Press will take any article title and make it a heading one. 
- It's also important to check if there are any header tags created by the theme you're using, and modify them so they don't interfere with the header tags you've created.
  - It's important that when you make any changes, such as the heading two or heading three, that you verify that your cascading style sheets, your CSS, isn't applying a very specific style to H2 versus H3.
- It's important that you evaluate whether your heading tags are being assigned from within the page or post editor or whether they're being assigned from within the theme file. 
  - It's relatively easy to modify these theme files for simple changes like modifying heading two to heading three. 
  - And a lot of template-driven themes are going to come with common heading errors, so you'll likely spend time evaluating those and fixing them.
- Additionally, you can search for `<h1>`, `<h2>` tags with Chrome's inspector tool to see the full amount of heading tags within each page.

## Managing Architecture

- By default, WordPress comes configured with the plain permalink settings. 
  - A permalink is really the permanent address of the piece of content that is associated to that URL. 
  - Each page or article that you create will get a new permanent link. 
- By default, the plain permalink is what's configured, and this is the least user-friendly. 
  - In this case, WordPress simply assigns an ID and calls it good. And this does nothing for your user or for Google, as it provides no context. 
- A very popular option is the Month and name, or the Day and name options. 
  - You'll see this on a lot of older news websites, or older blogs that are updating their content frequently. 
  - This helps provide context to the end-user, as well as to Google. 
  - However, with the addition of structured data that allows us to tell Google the month, day, and year that an article was published within that structured data, we don't need to use the folder structure to provide that context. 
  - And this unnecessarily makes the URL longer, which is actually less enticing to a user. 
- There's also have Numeric which is a format of Plain, it adds in a categorical component for archives. 
- Finally, we have what is by far the best option for SCO, "Post Name".
  - This allows you to provide each page a very clean, simple, plain English user-friendly URL. 
  - This is called "the slug," and each article that you publish will have a customizable slug that is appended to the URL.
- There are some instances where you want to deviate from Post Name. 
  - That's if you have a very categorical, driven website. 
  - Eg. If you run a blog that has categories that are incredibly important to the context of the material, or if you run, say, an e-commerce site that has products that live within categories, you're going to want to adjust this structure. 
  - You can do that by selecting Custom Structure and then before Post-name, you'll select the category tag to insert it.
- There's not really a right or wrong answer within the e-commerce context. 
  - It really depends on the makeup of your site and the way that you categorize your content. 
- But above all, try to identify the simplest and shortest permalink structure to maximize your SEO architecture.

### Permalink Best Practices

- As you create articles and pages, never allow WordPress to default create your slug. 
  - You should always review this slug and customize it before you publish your content. 
- Regarding best practices, first is you should always use hyphens to differentiate the words, which WordPress does by default. 
- The second best practice is to remove any erroneous keywords, characters, and stop words. 
  - Eg. Get rid of the ampersands, apostrophes, which will result in a much cleaner URL. 
- The next best practice is to keep your permalinks as short as possible. 
  - Keywords that really matter in this article that you're publishing. 
- As you go to create your content, which has a hand in your overall WordPress site architecture, it's important that you pay particular attention to how you're creating those permalinks and how you're keeping them short and concise, removing those unnecessary words, and always using hyphens.

### HTTPS Status Codes

- Whenever you, or  search engine, request a website from a web server, a https response code is returned, and this response code can tell us a little bit about what happened during that communication. 
- These response codes, these HTTP status codes, show up quite a bit in technical SEO.
- The first one that we see quite often is **200**, 200 means okay. 
  - This tells the browser, or the crawler, that the request was successful, whatever we asked for came back, and everything worked. 
- If we see a **301**, this is essentially a redirection. 301 means move permanently. 
  - It means that whatever we asked for has been assigned a new permanent location, and anytime we ask for that old location, we should instead ask for the new location. 
  - This is a permanent redirect. So it's basically saying, "Hey, I've moved, and I'll always be over here now." 
  - This is the most common type of redirection that we use in SEO and we often are always checking to make sure that our redirects are 301's. 
- Another type of redirection is the **302**, and this simply means found. 
  - The server is responding to the request with a page from a different location, but it's going to tell the requester that continue using this original address because it's really a temporary redirect. 
  - It means I plan to come back to return back to this origin at some point. 
  - Now this approach is really not recommended. It's really not an effective way to instruct search engines that a page or a site has moved, and there are very small use cases when a 302 makes sense. 
- A **404** is the error code. It's the file not found status code. 
  - It means the server didn't find anything that you were looking for, and there's no indication as to whether this is a permanent or temporary condition. 
  - This typically happens when someone mistypes a URL, and the server says, "Hey, what you're looking for is not here." 
- In the 400 codes is also **410**, meaning gone. And this is how you tell a crawler that whatever they're asking for is no longer available, and it's never coming back. 
  - It means this is a permanent removal, and this is often how to remove content from the search engines. 
- The last two that you'll encounter are in the 500's, **500** meaning internal server error. 
  - This is simply a generic error message, and it's essentially saying there's been an unexpected condition. We've encountered a problem, but I know nothing more about it. 
- And the final error code is a **503**, and this means service unavailable. 
  - The server cannot handle the request, either it's temporarily overloaded, it's been shut down, or there's some scheduled maintenance, but a 503 indicates we hope that this problem will be alleviated soon, which means that a crawler or a server may try to come back at a later point. 
- These are the most common status codes, and they will come in quite handy as you begin dive deeper into technical SEO.

### Modifying Existing Links

- A fairly common scenario within any SEO effort is changing a URL.
  - When editing links directly in WordPress, the old olink will automatically redirect to the new one.
- By default, WordPress automatically will take any URL changes to your articles or pages and create a 301 redirect. 
  - It's important that you verify that the redirect is happening properly and that it's a 301, and to do that, use a resource within Terminal, or, on a PC, command line, called curl. 
- Use `curl -I -L`. 
  - The capital I flag means only fetch the headers, that is, the top of the response from the website. 
  - The capital L flag stands for location, this means that if the server reports that the page has moved to a different location, say, a 301 or a 302 redirect, then curl will follow that request down the chain. 
  - In order to test that URL and make sure that it's redirecting properly, use this flag and paste in the original URL.

### Changing Permalink Structure

- Managing redirects when you want to change a post or a page URL is relatively simple, but it can be quite a bit more complicated if you want to change the overall permalink structure.
- If you simply switch, WordPress is not going to automatically 301 redirect our traffic. 
    - And this means anyone who's going to the old URL is going to hit a 404, and that will dramatically decrease our traffic and impact our SEO performance. 
    - If you have a brand new website, switching is no concern because the URLs have not been trafficked anywhere. 
    - However, with an established website, you're going to want to make sure that you properly set up your 301 redirect between your old permalink and your new permalink. 
- The first, and by far the best, approach would be to set up a rewrite rule in your .htaccess file, which lives on the server. 
    - This is the fastest and most direct way to manage redirects, however it is by far that most complicated.
-  The second and also highly popular way is to use a plugin to manage that redirect, and this will work for most situations. 
    - The reason to avoid plugins is that the more plugins you add to your site, the more that you run into the chance that these plugins interact with one another in a negative way. 
    - Meaning, one plugin may impact the functionality of another plugin and you get undesirable results. But a plugin is going to work for most situations,
- In this case, use the Redirection plugin by John Godley.
    - With this plugin, you can toggle to monitor any permalink changes in WordPress, which would automatically manage its redirection if we made any changes, and we can choose to keep a log of all the redirects and 404 errors. 
    - This is helpful for troubleshooting. Every time a request comes in, we'll see if a redirect worked or if a redirect didn't work and served a 404 error. 
- In addition, the plugin gives the ability to bake in a new redirection, and we start by adding the source URL and then the target URL. 
    - If we had a relatively simple site, we could manually add each redirect one at a time.

## HTTP vs. HTTPS

- It's really important that your site makes the move to HTTPS if you haven't done it already. 
  - Google is determined to make HTTPS the standard across the web and it provides a very secure experience for your visitors. 
- HTTP stands for hypertext transfer protocol and it's designed to let two different systems communicate. 
  - This means that your web browser can communicate with a web server to deliver a website. 
  - The protocol defines how all of that information should be formatted and transmitted. 
- HTTP was designed to transfer all of that information openly in plain text. 
  - It's essentially a postcard. Your message is visible to anyone who handles that postcard or anyone who finds a way to take a look at that postcard before it arrives at the destination. 
- If you want something to be secure, you need to hide the contents, and that's where the S comes from. 
  - It means secure. It does the same thing, it encrypts the information before transmitting any messages. 
  - Essentially, it's going to put your contents in a secure envelope that only the intended recipient can open. 
- And additionally, HTTPS comes with authenticity. 
  - You need an SSL certificate to not only create that encryption, essentially secure that package, but also to prove that the website is who it says it is and nobody is impersonating it in an attempt to intercept that message. 
- You should be protecting all of your sites with HTTPS. 
  - Not only does it enhance security, it is a ranking factor for Google and the modern Chrome browser issues a warning to users for sites that aren't on HTTPS.
- Setting up HTTPS is going to vary from host to host. 
  - Some come with it built in out of the box, others require that you find and secure your own SSL certificate, but it's worth the effort.

### Migration to HTTPS

- If you're going to be migrating your WordPress site to HTTPS, you'll need to pay close attention to how you handle this migration. 
- After securing your SSL certificate there's still more work to be done. 
  - You'll need to make sure that all of your redirects are in place so HTTP automatically redirects to HTTPS, and you'll need to make sure that all of the code libraries and file hosting services you're using are also secure. 
- A really easy way to manage this setup is to use a lightweight plugin called *Really Simple SSL*. 
  - This plugin handles most of the issues that WordPress has with SSL. 
  - Say you're using a load balancer or there's no headers being passed, so WordPress can't detect your SSL. 
  - It also helps by automatically managing all of your incoming requests and redirecting them to HTTPS. 
  - It also changes your site URL and home URL to HTTPS, and it'll automatically solve all insecure content by forcing HTTP URLS to HTTPS. 
- The first thing that you want to do is take a look at the difference between the WordPress 301 redirect and the 301 at the .htaccess level. 
  - It's recommended that you set your 301 redirect from HTTP to HTTPS at the HT access level as the WordPress 301 redirect is living within the software whereas the HT access is living directly within your server. 
  - This can cause problems depending on how your site is configured, if you're unfamiliar, read the article about how to regain access in the event that your site goes into a redirect loop. 
- The .htaccess file is not writeable, and this is because the way that this server is configured doesn't give this user privileges to modify the .htaccess file. 
  - You'd have to manually copy and paste the information provided 
- Once you've configured HTTPS you'll want to test to make sure that it's working, and you can do that by running another crawl and making sure that all of your URLS 301 redirect to HTTPS and you don't receive any 404 errors. 
  - Furthermore you'll want to make sure that you update your site map if it doesn't automatically update, and you'll also want to make sure that you reconfigure any analytics, tracking, and say Google search console as all of those will likely have been configured as HTTP. 
- There's quite a bit that goes into this migration, but it's worth the effort. 

## Robots and Sitemaps

### Robots.txt

- A properly configured website is going to have a `robots.txt` file. 
  - This file is really important, because it creates the set of instructions that crawlers use when they arrive on your website. 
  - These instructions indicate what the crawler should crawl and what they should not crawl. Essentially, it disallows or allows certain behavior. 
- This file exists at `websitename.com/robots.txt`. 
  - All robots.txt files live at the same destination, and they're all case sensitive, so they will always be lowercase r in the robots. 

The default `robots.txt` that comes pre-installed on your WordPress website:

```txt
User-agent: *
Disallow: /wp-admin/
Allow: /wp-admin/admn-ajax.php

Sitemap: https://www.webitename.com/sitemap_index.xml
```
- First, it's saying the user agent (that's the piece of software that's crawling the website) is an asterisk which means all user agents must follow the directive below. 
  - That directive says you're not allowed to crawl the folder `wp-admin`. 
  - That's the folder that we use to log in and administer everything we're doing in WordPress, so it makes sense that we don't want the crawlers going through all of those URLs. 
  - It says you're allowed, however, to visit one particular URL within that folder, `admin-ajax`. 
- It's important to know that disallowing pages or subdirectories isn't a security feature, this isn't going to prevent people from accessing this content. 
  - This just tells the robots to not waste their time crawling it. 
  - This is really important, because a particular crawler, say Google, has a quota, an allotment of time that it's going to dedicate to crawling your website. 
  - Once that time has elapsed, it's done and it leaves. 
- If the crawler wastes time visiting content that is never going to be relevant for what people are searching for, it's content that you're never going to send traffic to, there's no point in having Google, or any other crawler, visit that content. 
  - That is why we use a robots.txt file. We use it to provide directives, the instructions that we want the crawler to follow. 

### Sitemaps

-  A sitemap lays out all of the content on your site as a way to indicate to both search engine spiders and sometimes visitors to your site, where all of the information exists. 
    - There are traditionally two types of sitemaps: The HTML sitemap and the XML sitemap. The HTML sitemap is usually for your users and the XML sitemap is used for crawlers.
- Essentially, the HTML sitemap is a page that allows you to navigate the categories and topics, a variety of sections. 
    - It's here to help users navigate a large website such as Lynda.com. 
- The sitemap that is most important when it comes to improving your SEO is your XML sitemap. 
    - Traditionally you find that at `/sitemap.xml`. However, you can look in the robots.txt file to see if it's somewhere else. 