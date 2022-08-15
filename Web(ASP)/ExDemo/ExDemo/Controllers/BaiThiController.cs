using ExDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ExDemo.Controllers
{
    public class BaiThiController : Controller
    {
        // GET: BaiThi
        OnlineShopDB onlineShopDB = new OnlineShopDB();
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult SanPhamTheoGia()
        {
            List<Product> products = onlineShopDB.Products.Where(n => n.Available == true).Take(4).ToList();
            return PartialView("NgoVanKhai_MainContent", products);
        }
        public ActionResult getAllCategries()
        {
            List<Category> categories = onlineShopDB.Categories.ToList();
            return PartialView("NgoVanKhai_Filter", categories);
        }

        public ActionResult LoadProductByCatId(int CatId)
        {
            List<Product> products;
            if (CatId == -1)
            {
                products = onlineShopDB.Products.Where(n => n.Available == true).ToList();
            }
            else
            {
                products = onlineShopDB.Products.Where(n => n.CategoryId == CatId && n.Available == true).ToList();
            }
            return PartialView("NgoVanKhai_MainContent", products);
        }
        public ActionResult signUp()
        {
            return View();
        }

        [HttpPost]
        public ActionResult signUp(Customer customer)
        {
            if (ModelState.IsValid)
            {
                onlineShopDB.Customers.Add(customer);
                onlineShopDB.SaveChanges();
                return Redirect("Index");
            }
            return View();
        }
    }
}