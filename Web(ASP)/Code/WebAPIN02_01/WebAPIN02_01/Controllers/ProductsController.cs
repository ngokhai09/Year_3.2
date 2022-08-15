using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebAPIN02_01.Models;

namespace WebAPIN02_01.Controllers
{
    public class ProductsController : ApiController
    {
        WebBanValiDataContext dbcontext = new WebBanValiDataContext();
        // GET api/products
        public IEnumerable<Product> GetAllProducts()
        {
            IList<Product> lstproducts = new List<Product>();
            var query = (from prods in dbcontext.tDanhMucSPs select prods).ToList();
            foreach(var item in query) 
            {
                lstproducts.Add(new Product
                {
                    MaSP = item.MaSP,
                    TenSP = item.TenSP,
                    GioiThieuSP = item.GioiThieuSP,
                    MaLoai = item.MaLoai
                });
            }
            return lstproducts;
        }

        // GET api/values/5
        //Lay san pham theo loai
        public IEnumerable<Product> GetProductsByCategory(string MaLoai)
        {
            IList<Product> lstproducts = new List<Product>();
            var query = (from prods in dbcontext.tDanhMucSPs
                         where prods.MaLoai == MaLoai
                         select prods).ToList();
            foreach (var item in query)
            {
                lstproducts.Add(new Product
                {
                    MaSP = item.MaSP,
                    TenSP = item.TenSP,
                    GioiThieuSP = item.GioiThieuSP,
                    MaLoai = item.MaLoai
                });
            }
            return lstproducts;
        }

        // GET api/values/5
        //Lay san pham theo Ma SP
        public Product GetProductsByID(string MaSP)
        {
            Product prod;
            var query = (from aprods in dbcontext.tDanhMucSPs
                         where aprods.MaSP == MaSP
                         select aprods).SingleOrDefault();
            
                prod = new Product
                {
                    MaSP = query.MaSP,
                    TenSP = query.TenSP,
                    GioiThieuSP = query.GioiThieuSP,
                    MaLoai = query.MaLoai
                };
            return prod;
        }

        // POST api/values
        public void Post([FromBody] string value)
        {
        }

        // PUT api/values/5
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/values/5
        public void Delete(int id)
        {
        }
    }
}
