using DeThi03.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DeThi03.Controllers
{
    public class BaiThiController : Controller
    {
        // GET: BaiThi
        Model1 db = new Model1();
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult getAllCategories()
        {
            List<Category> categories = db.Categories.ToList();
            return PartialView("NgoVanKhai_Nav", categories);
        }
        public ActionResult getAllProduct()
        {
            List<Product> products = db.Products.Where(n => n.UnitPrice <= 1000 && n.Available == true).ToList();
            return PartialView("NgoVanKhai_MainContent", products);
        }
        public ActionResult getProductByCatId(int CatId)
        {
            List<Product> products;
            if (CatId == -1)
            {
                products = db.Products.Where(n => n.Available == true && n.CategoryId == CatId).ToList();
            }
            else
            {
                products = db.Products.Where(n => n.Available == true && n.CategoryId == CatId).ToList();
            }
                
            return PartialView("NgoVanKhai_MainContent", products);
        }
        public ActionResult createProduct()
        {
            ViewBag.CategoryId = new SelectList(db.Categories.ToList().OrderBy(n => n.Name), "Id", "Name");
            return View();
        }

        [HttpPost]
        public ActionResult createProduct(Product product)
        {
            ViewBag.CategoryId = new SelectList(db.Categories.ToList().OrderBy(n => n.Name), "Id", "Name");
            if (ModelState.IsValid)
            {
                db.Products.Add(product);
                db.SaveChanges();
                return Redirect("Index");
            }
            return View();
        }
    }
}